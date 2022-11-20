package com.l08gr02.zelda.viewers;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.l08gr02.zelda.models.Gameplay;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.viewers.dungeon.DungeonViewer;

import java.io.IOException;

public class GameplayViewer {
    private final Screen screen;
    private final TextGraphics graphics;
    private DungeonViewer dungeonViewer;

    // constructor
    public GameplayViewer(int tWidth, int tHeight) throws IOException {
        TerminalSize tSize = new TerminalSize(tWidth, tHeight);

        // criar o terminal
        Terminal terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(tSize).createTerminal();

        // criar o screen
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null); // não precisamos do rato
        screen.startScreen();
        screen.doResizeIfNecessary();

        // criar os graphics
        graphics = screen.newTextGraphics();

        // desenhar o mapa
        dungeonViewer = new DungeonViewer();
    }

    // methods
    public Screen getScreen() {
        return screen;
    }

    public TextGraphics getGraphics() {
        return graphics;
    }

    public DungeonViewer getDungeonViewer() {
        return dungeonViewer;
    }

    public GameplayPresenter.ACTION getAction() throws IOException {
        KeyStroke key = screen.pollInput();

        switch (key.getKeyType()){
            case EOF :
                return GameplayPresenter.ACTION.QUIT;

            case ArrowUp :
                return GameplayPresenter.ACTION.UP;

            case ArrowDown :
                return GameplayPresenter.ACTION.DOWN;

            case ArrowLeft :
                return GameplayPresenter.ACTION.LEFT;

            case ArrowRight :
                return GameplayPresenter.ACTION.RIGHT;
        }

        // ler carateres
        if (key.getCharacter() == null){
            return GameplayPresenter.ACTION.NOTHING;
        }

        switch (key.getCharacter()){
            case 'w' :
                return GameplayPresenter.ACTION.UP;

            case 's' :
                return GameplayPresenter.ACTION.DOWN;

            case 'a' :
                return GameplayPresenter.ACTION.LEFT;

            case 'd' :
                return GameplayPresenter.ACTION.RIGHT;
        }

        return GameplayPresenter.ACTION.NOTHING;
    }
}
