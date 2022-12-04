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
            return GameplayPresenter.ACTION.NOTHING;
        }

        // ler não carateres
        switch (key.getKeyType()){
            case EOF, Escape -> {return GameplayPresenter.ACTION.QUIT;}

            case ArrowUp -> {return GameplayPresenter.ACTION.UP;}

            case ArrowDown -> {return GameplayPresenter.ACTION.DOWN;}

            case ArrowLeft -> {return GameplayPresenter.ACTION.LEFT;}

            case ArrowRight -> {return GameplayPresenter.ACTION.RIGHT;}

        }

        // ler carateres
        if (key.getCharacter() == null){
            return GameplayPresenter.ACTION.NOTHING;
        }

        switch (key.getCharacter()){
            case 'w' -> {return GameplayPresenter.ACTION.UP;}

            case 's' -> {return GameplayPresenter.ACTION.DOWN;}

            case 'a' -> {return GameplayPresenter.ACTION.LEFT;}

            case 'd' -> {return GameplayPresenter.ACTION.RIGHT;}

            case 'q'-> {return GameplayPresenter.ACTION.QUIT;}
        }

        return GameplayPresenter.ACTION.NOTHING;
    }

}
