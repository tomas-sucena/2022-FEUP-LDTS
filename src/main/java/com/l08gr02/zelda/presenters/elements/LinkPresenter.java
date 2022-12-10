package com.l08gr02.zelda.presenters.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.models.sound.SoundEffect;
import com.l08gr02.zelda.presenters.Presenter;
import com.l08gr02.zelda.viewers.elements.LinkViewer;

import java.util.List;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class LinkPresenter extends Presenter<Link> {
    private SoundEffect walkSFX;

    // constructor
    public LinkPresenter(Link model, LinkViewer viewer){
        super(model, viewer);

        walkSFX = new SoundEffect("walk_grass");
    }

    // methods
    public void moveUp() {
        model.up(model.getSpeed());
        walkSFX.play();
    }

    public void moveDown() {
        model.down(model.getSpeed());
        walkSFX.play();
    }

    public void moveLeft() {
        model.left(model.getSpeed());
        walkSFX.play();
    }

    public void moveRight() {
        model.right(model.getSpeed());
        walkSFX.play();
    }

    public void walk(){
        model.walk();
    }

    public void sprint(){
        model.sprint();
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
    }

}
