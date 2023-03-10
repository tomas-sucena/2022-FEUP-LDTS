package com.l08gr02.zelda.gui;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

public abstract class GUI {
    private final Camera camera;
    private final Set<Integer> pressedKeys;

    // constructor
    public GUI(int tWidth, int tHeight, int TILE_SIZE) throws URISyntaxException, IOException, FontFormatException {
        pressedKeys = new HashSet<>();

        // create the camera
        camera = new Camera(0, 0, tWidth, tHeight, TILE_SIZE);
    }

    // methods
    public Camera getCamera(){
        return camera;
    }

    public Set<Integer> getPressedKeys() {
        return pressedKeys;
    }

    public abstract TextGraphics getGraphics();
    public abstract void clear();
    public abstract void refresh() throws IOException;
    public abstract void close() throws IOException;
}
