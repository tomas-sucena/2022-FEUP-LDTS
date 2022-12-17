package com.l08gr02.zelda.presenters;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.viewers.Viewer;

public abstract class Presenter<T> {
    protected T model;
    protected Viewer<T> viewer;

    // construtor
    public Presenter(T model, Viewer<T> viewer){
        this.model = model;
        this.viewer = viewer;
    }

    // métodos
    public T getModel() {
        return model;
    }

    public abstract void update(GUI gui);
}
