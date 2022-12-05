package com.l08gr02.zelda.viewers;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.viewers.dungeon.DungeonViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

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

    public GameplayPresenter.ACTION getAction() throws IOException {
        KeyStroke key = gui.getScreen().pollInput();

        if (key == null){
            return ACTION.NOTHING;
        }

        // ler não carateres
        switch (key.getKeyType()){
            case EOF, Escape -> {return ACTION.QUIT;}

            case ArrowUp -> {return ACTION.UP;}

            case ArrowDown -> {return ACTION.DOWN;}

            case ArrowLeft -> {return ACTION.LEFT;}

            case ArrowRight -> {return ACTION.RIGHT;}

        }

        // ler carateres
        if (key.getCharacter() == null){
            return ACTION.NOTHING;
        }

        switch (key.getCharacter()){
            case 'w' -> {return ACTION.UP;}

            case 's' -> {return ACTION.DOWN;}

            case 'a' -> {return ACTION.LEFT;}

            case 'd' -> {return ACTION.RIGHT;}

            case 'q'-> {return ACTION.QUIT;}
        }

        return ACTION.NOTHING;
    }

}
