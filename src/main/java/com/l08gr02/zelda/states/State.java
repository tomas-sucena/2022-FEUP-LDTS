package com.l08gr02.zelda.states;

import com.l08gr02.zelda.controller.Controller;
import com.l08gr02.zelda.viewer.Viewer;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    // constructor
    public State(T model){
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();
}
