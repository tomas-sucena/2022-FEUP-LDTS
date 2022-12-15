package com.l08gr02.zelda.presenters.dungeon;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.gui.Camera;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.models.elements.CollidingElement;
import com.l08gr02.zelda.models.elements.Hitbox;
import com.l08gr02.zelda.models.elements.moving.Link;
import com.l08gr02.zelda.models.elements.moving.monsters.Monster;
import com.l08gr02.zelda.models.elements.tiles.Heart;
import com.l08gr02.zelda.models.elements.tiles.StaticTile;
import com.l08gr02.zelda.presenters.Presenter;
import com.l08gr02.zelda.presenters.elements.LinkPresenter;
import com.l08gr02.zelda.presenters.elements.MonsterPresenter;
import com.l08gr02.zelda.viewers.dungeon.DungeonViewer;
import com.l08gr02.zelda.viewers.elements.LinkViewer;
import com.l08gr02.zelda.viewers.elements.MonsterViewer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class DungeonPresenter extends Presenter<Dungeon> {
    private LinkPresenter linkPresenter;
    private List<MonsterPresenter> monsterPresenters;

    // constructor
    public DungeonPresenter(Dungeon model, DungeonViewer viewer, Camera camera) {
        super(model, viewer);

        // criar os presenters
        linkPresenter = new LinkPresenter(model.getLink(), new LinkViewer(camera));
        monsterPresenters = new LinkedList<>();

        for (Monster monster : model.getMonsters()){
            monsterPresenters.add(new MonsterPresenter(monster, new MonsterViewer(camera)));
        }
    }

    // methods
    @Override
    public void update(TextGraphics graphics, List<ACTION> actions) {
        // verificar as colisões
        checkCollisions();

        viewer.draw(graphics, model);
        linkPresenter.update(graphics, actions);

        for (MonsterPresenter monsterPresenter : monsterPresenters){
            monsterPresenter.update(graphics, actions);
        }
    }


    private void checkCollisions(){
        checkLinkCollisions();

        // verificar se os monstros estão a colidir
        for (Monster monster : model.getMonsters()){
            checkMonsterCollisions(monster);
        }

        // verificar se o Link está a atacar
        if (!linkPresenter.isAttacking()) {
            return;
        }

        Link link = model.getLink();
        Hitbox swordHitbox = link.getAttackHitbox();

        for (MonsterPresenter monsterPresenter : monsterPresenters){
            Monster monster = monsterPresenter.getModel();

            if (!monster.getHitbox().intersects(swordHitbox)){
                continue;
            }

            monsterPresenter.takeDamage(1, link.getDirection());
        }

        model.getMonsters().removeIf(monster -> monster.getHearts() <= 0);
        monsterPresenters.removeIf(monsterPresenter -> monsterPresenter.getModel().getHearts() <= 0);
    }

    private void checkLinkCollisions(){
        Link link = model.getLink();

        List<CollidingElement> linkObstacles = new LinkedList<>();

        for (StaticTile stile : model.getStiles()){
            if (!stile.isCollidable()){
                continue;
            }

            linkObstacles.add(stile);
        }

        for (Monster monster : model.getMonsters()){
            if (link.collidesWith(monster)){
                linkPresenter.takeDamage((float) 0.75, monster.getDirection());
                linkObstacles.add(monster);

                break;
            }
        }

        for (Heart heart : model.getHearts()){
            if (link.collidesWith(heart)){
                linkPresenter.heal(1);
                model.getHearts().remove(heart);

                break;
            }
        }

        link.setObstacles(linkObstacles);
    }

    private void checkMonsterCollisions(Monster monster){
        List<CollidingElement> monsterObstacles = new LinkedList<>();

        for (Monster m : model.getMonsters()){
            if (monster == m || !monster.collidesWith(m)){
                continue;
            }

            ACTION direction = monster.getDirection();

            // mudar a direção dos monstros que colidem
            monster.setDirection(m.getDirection());
            m.setDirection(direction);

            break;
        }

        for (StaticTile stile : model.getStiles()){
            if (!stile.isCollidable()){
                continue;
            }

            monsterObstacles.add(stile);
        }

        for (Heart heart : model.getHearts()){
            if (monster.collidesWith(heart)){
                monster.heal(1);
                model.getHearts().remove(heart);

                break;
            }
        }

        monster.setObstacles(monsterObstacles);
    }

}
