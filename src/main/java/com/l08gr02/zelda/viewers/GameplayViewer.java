package com.l08gr02.zelda.viewers;

import com.l08gr02.zelda.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;
import static java.awt.event.KeyEvent.*;

public class GameplayViewer {
    private final GUI gui;

    // constructor
    public GameplayViewer(int width, int height, int TILE_SIZE) throws IOException, URISyntaxException, FontFormatException {
        int tWidth = width * TILE_SIZE;
        int tHeight = height * TILE_SIZE;

        // criar o GUI
        gui = new GUI(tWidth, tHeight, TILE_SIZE,6);
    }

    // methods
    public GUI getGUI() {
        return gui;
    }

    public List<ACTION> getActions() {
        List<ACTION> actions = new LinkedList<>();
        actions.add(ACTION.NOTHING);

        Set<Integer> keys = gui.getPressedKeys();

        // casos especiais
        if (keys.contains(VK_Q) || keys.contains(VK_ESCAPE)){
            actions.add(ACTION.QUIT);
            return actions;
        }
        else if (keys.contains(VK_SPACE)){
            actions.add(ACTION.ATTACK);
            return actions;
        }

        if (keys.contains(VK_SHIFT)){
            actions.add(ACTION.SPRINT);
        }

        if (keys.contains(VK_UP) || keys.contains(VK_W)){
            actions.add(ACTION.UP);
        }

        if (keys.contains(VK_DOWN) || keys.contains(VK_S)){
            actions.add(ACTION.DOWN);
        }

        if (keys.contains(VK_LEFT) || keys.contains(VK_A)){
            actions.add(ACTION.LEFT);
        }

        if (keys.contains(VK_RIGHT) || keys.contains(VK_D)){
            actions.add(ACTION.RIGHT);
        }

        return actions;
    }

}
