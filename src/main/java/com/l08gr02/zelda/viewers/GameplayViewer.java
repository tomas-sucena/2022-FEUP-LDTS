package com.l08gr02.zelda.viewers;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.l08gr02.zelda.gui.Camera;
import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.viewers.dungeon.DungeonViewer;

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
    private final Camera camera;

    // constructor
    public GameplayViewer(int tWidth, int tHeight) throws IOException, URISyntaxException, FontFormatException {
        // criar o GUI
        gui = new GUI(tWidth, tHeight, 6);

        // criar a câmara
        camera = new Camera(0, 0, tWidth, tHeight);
    }

    // methods
    public Camera getCamera() {
        return camera;
    }

    public Screen getScreen() {
        return gui.getScreen();
    }

    public TextGraphics getGraphics() {
        return gui.getGraphics();
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
