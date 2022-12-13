package com.l08gr02.zelda.presenters;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.viewers.Viewer;

import java.util.List;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public abstract class Presenter<T> {
    protected T model;
    protected Viewer<T> viewer;

    // construtor
    public Presenter(T model, Viewer<T> viewer){
        this.model = model;
        this.viewer = viewer;
    }

    // métodos
    public abstract void update(TextGraphics graphics, List<ACTION> actions);
}
