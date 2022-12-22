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


        Terminal terminal = gui.createTerminal(tWidth, tHeight, fontSize);

        assertEquals(tWidth, terminal.getTerminalSize().getColumns());
        assertEquals(tHeight, terminal.getTerminalSize().getRows());

    }

    @Test
    public void testGetGraphics() throws Exception {
        // Arrange
        LanternaGUI gui = new LanternaGUI(80, 25, 16, 12);

        // Act
        TextGraphics graphics = gui.getGraphics();

        // Assert
        assertTrue(graphics instanceof TextGraphics);
    }

}