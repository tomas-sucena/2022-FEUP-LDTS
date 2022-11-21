package com.l08gr02.zelda.presenters;

import com.googlecode.lanterna.screen.Screen;
import com.l08gr02.zelda.viewers.Viewer;

public abstract class Presenter<T> {
    protected T model;
    protected Viewer<T> viewer;

    // constructor
    public Presenter(T model, Viewer<T> viewer){
        this.model = model;
        this.viewer = viewer;
    }

    // methods
    public abstract void update(Screen screen, GameplayPresenter.ACTION action);
}
