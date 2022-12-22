package com.l08gr02.zelda.presenters.elements.monsters;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.elements.moving.monsters.Log;
import com.l08gr02.zelda.viewers.elements.monsters.LogViewer;

import java.util.Random;

public class LogPresenter extends MonsterPresenter<Log> {
    private int actionLockCounter = 0;
    private int genMove = 2;

    // constructor
    public LogPresenter(Log model, LogViewer viewer){
        super(model, viewer);
    }

    // methods
    /*public void setTarget(Mover target){
        this.target = target;
    }*/

    @Override
    public void update(GUI gui) {
        super.decreaseImmunity();

        if (!model.collidesWith(gui.getCamera())){
            return;
        }

        actionLockCounter++;

        if (actionLockCounter > 60) {
            Random rng = new Random();
            genMove = rng.nextInt(4);
            actionLockCounter = 0;
        }

        switch (genMove){
            case 0 -> moveUp(model.getSpeed());
            case 1 -> moveDown(model.getSpeed());
            case 2 -> moveLeft(model.getSpeed());
            case 3 -> moveRight(model.getSpeed());
        }

        ((LogViewer) viewer).setSprite(model.getDirection());
        viewer.draw(gui, model);
    }

}
