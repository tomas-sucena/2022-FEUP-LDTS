package com.l08gr02.zelda.presenters.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.elements.moving.Monster;
import com.l08gr02.zelda.presenters.Presenter;
import com.l08gr02.zelda.viewers.elements.MonsterViewer;

import java.util.List;
import java.util.Random;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class MonsterPresenter extends Presenter<Monster> {
    private int actionLockCounter = 0;
    private int genMove = 2;
    private ACTION action = ACTION.LEFT;

    // constructor
    public MonsterPresenter(Monster model, MonsterViewer viewer) {
        super(model, viewer);
    }

    // methods
    public void moveUp(){
        model.up(1);
    }

    public void moveDown(){
        model.down(1);
    }

    public void moveLeft(){
        model.left(1);
    }

    public void moveRight(){
        model.right(1);
    }

    @Override
    public void update(TextGraphics graphics, List<ACTION> actions) {
        viewer.draw(graphics, model);
        actionLockCounter++;

        if(actionLockCounter > 60) {
            Random rnd = new Random();
            genMove = rnd.nextInt(4);
            actionLockCounter=0;
        }

        switch(genMove){
                case 0 -> {moveUp(); action=ACTION.UP;}
                case 1 -> {moveDown(); action=ACTION.DOWN;}
                case 2 -> {moveLeft(); action=ACTION.LEFT;}
                case 3 -> {moveRight(); action=ACTION.RIGHT;}
        }

        ((MonsterViewer) viewer).setSprite(action);
        viewer.draw(graphics, model);
    }

}
