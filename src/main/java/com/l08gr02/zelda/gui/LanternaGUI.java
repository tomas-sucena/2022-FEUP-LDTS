package com.l08gr02.zelda.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Set;

public class LanternaGUI extends GUI {
    private final Screen screen;
    private final TextGraphics graphics;

    // constructor
    public LanternaGUI(int tWidth, int tHeight, int TILE_SIZE, int fontSize) throws URISyntaxException, IOException, FontFormatException {
        super(tWidth, tHeight, TILE_SIZE);

        // criar o screen
        screen = new TerminalScreen(createTerminal(tWidth, tHeight, fontSize));

        screen.setCursorPosition(null); // não precisamos do rato
        screen.startScreen();
        screen.doResizeIfNecessary();

        // criar os graphics
        graphics = screen.newTextGraphics();
    }

    // methods
    @Override
    public TextGraphics getGraphics() {
        return graphics;
    }

    @Override
    public void clear(){
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    private Terminal createTerminal(int tWidth, int tHeight, int fontSize) throws URISyntaxException, IOException, FontFormatException {
        // definir o tamanho do terminal
        TerminalSize tSize = new TerminalSize(tWidth, tHeight);

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(tSize);

        // criar a fonte
        AWTTerminalFontConfiguration fontConfig = loadFont(fontSize);

        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);

        // adicionar os listeners
        Terminal terminal = terminalFactory.createTerminal();
        addListeners(terminal);

        return terminal;
    }

    public void addListeners(Terminal terminal){
        ((AWTTerminalFrame) terminal).getComponent(0).addKeyListener(new KeyAdapter() {
            Set<Integer> pressedKeys = getPressedKeys();

            @Override
            public void keyPressed(KeyEvent e) {
                pressedKeys.add(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                pressedKeys.remove(e.getKeyCode());
            }
        });

        ((AWTTerminalFrame) terminal).addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private AWTTerminalFontConfiguration loadFont(int fontSize) throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/font1.0.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, fontSize);

        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

}
