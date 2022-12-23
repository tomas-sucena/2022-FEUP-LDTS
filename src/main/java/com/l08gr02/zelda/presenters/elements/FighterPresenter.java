package com.l08gr02.zelda.presenters.elements;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.elements.moving.Fighter;
import com.l08gr02.zelda.viewers.Viewer;

public abstract class FighterPresenter<T extends Fighter> extends CreaturePresenter<T> {
    // constructor
    public FighterPresenter(T model, Viewer<T> viewer){
        super(model, viewer);
    }

    // methods
    public void attack(){
        model.attack();
    }

    @Override
    public abstract void update(GUI gui);
}
