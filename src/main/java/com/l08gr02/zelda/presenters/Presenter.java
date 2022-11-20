package com.l08gr02.zelda.presenters;

import com.l08gr02.zelda.viewers.Viewer;

public abstract class Presenter<T> {
    private T model;
    private Viewer<T> viewer;

    // constructor
    public Presenter(T model, Viewer<T> viewer){
        this.model = model;
        this.viewer = viewer;
    }
}
