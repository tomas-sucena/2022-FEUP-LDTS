package com.l08gr02.zelda.viewers;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.l08gr02.zelda.models.elements.Position;
import org.w3c.dom.Text;

import java.io.IOException;

public class GameViewer {
    private final Screen screen;
    private final TextGraphics graphics;

    // constructor
    public GameViewer(int tWidth, int tHeight) throws IOException {
        // criar o terminal
        Terminal terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(tWidth, tHeight))
                .createTerminal();

        // criar o screen
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null); // não precisamos do rato
        screen.startScreen();
        screen.doResizeIfNecessary();

        // criar os graphics
        graphics = screen.newTextGraphics();
    }

    // methods
    public Screen getScreen() {
        return screen;
    }

    public TextGraphics getGraphics() {
        return graphics;
    }

    public void drawLink(Position position) {
        screen.setCharacter(10, 10, TextCharacter.fromCharacter('L')[0]);
    }
}
