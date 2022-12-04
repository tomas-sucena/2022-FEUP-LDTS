package com.l08gr02.zelda.viewers;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalFactory;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.viewers.dungeon.DungeonViewer;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;


public class GameplayViewer {
    private final Screen screen;
    private final TextGraphics graphics;
    private DungeonViewer dungeonViewer;

    // constructor
    public GameplayViewer(int tWidth, int tHeight) throws IOException, URISyntaxException, FontFormatException {
        TerminalSize tSize = new TerminalSize(tWidth, tHeight);

        // criar o terminal
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(tSize);
        AWTTerminalFontConfiguration fontConfig = loadFont();
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        /*((AWTTerminalFrame)terminal).addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });*/

        // criar o screen
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null); // não precisamos do rato
        screen.startScreen();
        screen.doResizeIfNecessary();

        // criar os graphics
        graphics = screen.newTextGraphics();

        // desenhar o mapa
        dungeonViewer = new DungeonViewer(tWidth, tHeight);
    }

    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/font1.0.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 5);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
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
