package com.l08gr02.zelda.viewers;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.l08gr02.zelda.viewers.map.MapViewer;

import java.io.IOException;

public class GameViewer {
    private final Screen screen;
    private final TextGraphics graphics;
    private MapViewer mapViewer;

    // constructor
    public GameViewer(int tWidth, int tHeight) throws IOException {
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
        mapViewer = new MapViewer(graphics);
    }

    // methods
    public Screen getScreen() {
        return screen;
    }

    public TextGraphics getGraphics() {
        return graphics;
    }

}
