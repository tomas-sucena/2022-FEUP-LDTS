package com.l08gr02.zelda.presenters.dungeon;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.models.elements.CollidingElement;
import com.l08gr02.zelda.models.elements.moving.Link;
import com.l08gr02.zelda.models.elements.moving.Mover;
import com.l08gr02.zelda.models.elements.tiles.Heart;
import com.l08gr02.zelda.models.sound.SoundEffect;
import com.l08gr02.zelda.presenters.Presenter;
import com.l08gr02.zelda.presenters.elements.LinkPresenter;
import com.l08gr02.zelda.presenters.elements.MonsterPresenter;
import com.l08gr02.zelda.viewers.dungeon.DungeonViewer;

import java.util.LinkedList;
import java.util.List;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class DungeonPresenter extends Presenter<Dungeon> {
    private LinkPresenter linkPresenter;
    private List<MonsterPresenter> monsterPresenters;
    private SoundEffect healingSFX;

    // constructor
    public DungeonPresenter(Dungeon model, DungeonViewer viewer) {
        super(model, viewer);

        linkPresenter = new LinkPresenter(model.getLink(), viewer.getLinkViewer());

        healingSFX = new SoundEffect("heart");
    }

    // methods
    @Override
    public void update(TextGraphics graphics, List<ACTION> actions) {
        // verificar as colisões
        checkCollisions();

        viewer.draw(graphics, model);
        linkPresenter.update(graphics, actions);
    }

    public void checkCollisions(){
        Mover mover = model.getLink();

        // verificar se o Link está a colidir
        List<CollidingElement> obstacles = new LinkedList<>();

        for (Heart heart : model.getHearts()){
            if (mover.collidesWith(heart)){
                ((Link) mover).heal(1);
                healingSFX.play();
                model.getHearts().remove(heart);

                break;
            }
        }

        mover.setObstacles(obstacles);

        // verificar se os monstros estão a colidir
        // ...
    }
}
