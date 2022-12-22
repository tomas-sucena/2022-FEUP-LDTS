package com.l08gr02.zelda.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LanternaGUITest {

    @Test
    public void testCreateTerminal() throws Exception {
        // Arrange
        int tWidth = 80;
        int tHeight = 25;
        int fontSize = 12;
        LanternaGUI gui = new LanternaGUI(tWidth, tHeight, 16, fontSize);


        // Act
        Terminal terminal = gui.createTerminal(tWidth, tHeight, fontSize);

        // Assert
        assertEquals(tWidth, terminal.getTerminalSize().getColumns());
        assertEquals(tHeight, terminal.getTerminalSize().getRows());
        // TODO: add assertions to verify that the font configuration is correct and that the listeners are added
    }

    @Test
    public void testGetGraphics() throws Exception {
        LanternaGUI gui = new LanternaGUI(80, 25, 16, 12);

        TextGraphics graphics = gui.getGraphics();

        assertTrue(graphics instanceof TextGraphics);
    }

    @Test
    public void testClear() throws Exception {


    }

    @Test
    public void testRefresh() throws Exception {
        // Arrange
        LanternaGUI gui = new LanternaGUI(80, 25, 16, 12);

        // Act
        gui.refresh();

        // Assert
        // TODO: add assertions to verify that the screen is refreshed
    }

    @Test
    public void testClose() throws Exception {
        // Arrange
        LanternaGUI gui = new LanternaGUI(80, 25, 16, 12);

        // Act
        gui.close();

        // Assert
        // TODO: add assertions to verify that the screen is closed
    }

}