package com.l08gr02.zelda.presenters.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.elements.moving.Link;
import com.l08gr02.zelda.models.sound.SoundEffect;
import com.l08gr02.zelda.viewers.elements.LinkViewer;

import java.util.List;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class LinkPresenter extends MoverPresenter<Link> {
    private SoundEffect walkSFX;
    private SoundEffect swordSFX;

    // constructor
    public LinkPresenter(Link model, LinkViewer viewer){
        super(model, viewer);

        walkSFX = new SoundEffect("walk_grass");
        swordSFX = new SoundEffect("sword");
    }

    // métodos
    public void walk(){
        model.walk();
    }

    public void sprint(){
        model.sprint();
    }

    public void playSoundEffects(List<ACTION> actions){
        if (actions.contains(ACTION.ATTACK)){
            swordSFX.play();
        }
        else if (actions.contains(ACTION.UP) || actions.contains(ACTION.DOWN) ||
                 actions.contains(ACTION.LEFT) || actions.contains(ACTION.RIGHT)){
            walkSFX.play();
        }
    }

    @Override
    public void update(TextGraphics graphics, List<ACTION> actions) {
        walk();

        // verificar se o Link está a atacar
        if (((LinkViewer) viewer).isAttacking()){
            ((LinkViewer) viewer).setSprite(ACTION.ATTACK);
            viewer.draw(graphics, model);

            return;
        }

        for (ACTION action : actions){
            ((LinkViewer) viewer).setSprite(action);

            switch (action){
                case UP -> {moveUp();}

                case DOWN -> {moveDown();}

                case LEFT -> {moveLeft();}

                case RIGHT -> {moveRight();}

                case SPRINT -> {sprint();}
            }
        }

        viewer.draw(graphics, model);

        playSoundEffects(actions);
    }

}
