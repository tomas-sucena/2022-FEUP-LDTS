package com.l08gr02.zelda.controller;

import com.l08gr02.zelda.Game;
import com.l08gr02.zelda.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    // constructor
    public Controller(T model){
        this.model = model;
    }

    // methods
    public T getModel(){
        return model;
    }

    public abstract void step(Game game, GUI.ACTION a, long time) throws IOException;
}
