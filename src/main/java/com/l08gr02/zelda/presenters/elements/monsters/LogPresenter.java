package com.l08gr02.zelda.presenters.elements.monsters;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.elements.moving.Mover;
import com.l08gr02.zelda.models.elements.moving.monsters.Log;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.viewers.elements.monsters.LogViewer;

import static java.lang.Math.abs;

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

    @Override
    public void update(GUI gui){
        int diff_x = target.getPosition().getX() - model.getPosition().getX();
        int diff_y = target.getPosition().getY() - model.getPosition().getY();

        int new_x = model.getPosition().getX();
        int new_y = model.getPosition().getY();

        if (abs(diff_x) > abs(diff_y)) {
            new_x += (diff_x > 0) ? 1 : -1;
        }
        else {
            new_y += (diff_y > 0) ? 1 : -1;
        }

        ((LogViewer) viewer).setSprite(GameplayPresenter.ACTION.LEFT);
        viewer.draw(gui, model);
    }

}
