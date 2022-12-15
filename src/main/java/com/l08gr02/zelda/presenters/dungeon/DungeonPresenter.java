package com.l08gr02.zelda.presenters.dungeon;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.Direction;
import com.l08gr02.zelda.gui.Camera;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.models.elements.CollidingElement;
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


    public void checkCollisions(){
        Link link = model.getLink();

        // verificar se o Link está a colidir
        List<CollidingElement> obstacles = new LinkedList<>();

        for (StaticTile stile : model.getStiles()){
            if (stile.isCollidable() && link.collidesWith(stile)){
                obstacles.add(stile);

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

        for (Monster monster : model.getMonsters()){
            if (link.collidesWith(monster)){
                linkPresenter.takeDamage((float) 0.75);
                obstacles.add(monster);

                break;
            }
        }

        link.setObstacles(obstacles);

        // verificar se os monstros estão a colidir
        for (int i = 0; i < model.getMonsters().size(); i++){
            List<CollidingElement> obst = new LinkedList<>();

            Monster m = model.getMonsters().get(i);

            for (int j = 0; j < model.getMonsters().size(); j++){
                Monster monster = model.getMonsters().get(j);

                if (i != j && m.collidesWith(monster)){
                    ACTION direction = m.getDirection();

                    m.setDirection(monster.getDirection());
                    monster.setDirection(direction);
                }
            }

            for (StaticTile stile : model.getStiles()){
                if (stile.isCollidable() && m.collidesWith(stile)){
                    obst.add(stile);

                    break;
                }
            }

            m.setObstacles(obst);
        }

        for (Iterator<Heart> it = model.getHearts().iterator(); it.hasNext();){
            Heart heart = it.next();

            for (Monster monster : model.getMonsters()){
                if (monster.collidesWith(heart)){
                    monster.heal(1);
                    model.getHearts().remove(it);

                    break;
                }
            }
        }

        // verificar se o Link está a atacar
        if (linkPresenter.isAttacking()){
            for (MonsterPresenter monsterPresenter : monsterPresenters){
                Monster monster = monsterPresenter.getModel();

                if (monster.getHitbox().intersects(link.getAttackHitbox())){
                    monster.takeDamage(1);
                }
            }
        }

        model.getMonsters().removeIf(monster -> monster.getHearts() <= 0);
        monsterPresenters.removeIf(monsterPresenter -> monsterPresenter.getModel().getHearts() <= 0);
    }

}
