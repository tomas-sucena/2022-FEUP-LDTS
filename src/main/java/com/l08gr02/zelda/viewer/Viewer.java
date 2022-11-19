package com.l08gr02.zelda.viewer;

import com.l08gr02.zelda.gui.GUI;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    // constructor
    public Viewer(T model){
        this.model = model;
    }

    // methods
    public T getModel(){
        return model;
    }

    protected abstract void drawElements(GUI gui);

    public void draw(GUI gui) throws IOException{
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

}
