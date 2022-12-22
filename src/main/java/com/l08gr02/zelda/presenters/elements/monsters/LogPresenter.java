package com.l08gr02.zelda.presenters.elements.monsters;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.elements.moving.Mover;
import com.l08gr02.zelda.models.elements.moving.monsters.Log;
import com.l08gr02.zelda.viewers.elements.moving.monsters.LogViewer;

public class LogPresenter extends MonsterPresenter<Log> {
    private Mover target;

    // constructor
    public LogPresenter(Log model, LogViewer viewer){
        super(model, viewer);
    }

    // methods
    public void setTarget(Mover target){
        this.target = target;
    }

    public void chaseTarget(){
        int diff_y = target.getPosition().getY() - model.getPosition().getY();

        if (diff_y > 0){
            moveDown(model.getSpeed());
        }
        else if (diff_y < 0){
            moveUp(model.getSpeed());
        }

        int diff_x = target.getPosition().getX() - model.getPosition().getX();

        if (diff_x > 0){
            moveRight(model.getSpeed());
        }
        else if (diff_x < 0){
            moveLeft(model.getSpeed());
        }
    }

    @Override
    public void update(GUI gui) {
        if (!mustUpdate(gui)){
            return;
        }

        chaseTarget();

        ((LogViewer) viewer).setSprite(model.getDirection());
        viewer.draw(gui, model);
    }

}
