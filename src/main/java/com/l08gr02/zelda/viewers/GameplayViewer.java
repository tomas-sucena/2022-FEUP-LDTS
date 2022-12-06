package com.l08gr02.zelda.viewers;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.viewers.dungeon.DungeonViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;
import static java.awt.event.KeyEvent.*;

public class GameplayViewer {
    private final GUI gui;
    private DungeonViewer dungeonViewer;

    // constructor
    public GameplayViewer(int tWidth, int tHeight) throws IOException, URISyntaxException, FontFormatException {
        // criar o GUI
        gui = new GUI(tWidth, tHeight, 6);

        // desenhar o mapa
        dungeonViewer = new DungeonViewer(tWidth, tHeight);
    }

    // methods
    public Screen getScreen() {
        return gui.getScreen();
    }

    public TextGraphics getGraphics() {
        return gui.getGraphics();
    }

    public DungeonViewer getDungeonViewer() {
        return dungeonViewer;
    }

    public List<ACTION> getActions() {
        List<ACTION> actions = new LinkedList<>();
        actions.add(ACTION.NOTHING);

        for (Integer i : gui.getPressedKeys()){
            switch (i) {
                case VK_Q, VK_ESCAPE -> {actions.add(ACTION.QUIT);}

                case VK_UP, VK_W -> {actions.add(ACTION.UP);}

                case VK_DOWN, VK_S -> {actions.add(ACTION.DOWN);}

                case VK_LEFT, VK_A -> {actions.add(ACTION.LEFT);}

                case VK_RIGHT, VK_D -> {actions.add(ACTION.RIGHT);}
            }
        }

        return actions;
    }

}
