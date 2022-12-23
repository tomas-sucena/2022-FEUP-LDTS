package com.l08gr02.zelda.Viewers;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.elements.tiles.Heart;
import com.l08gr02.zelda.viewers.elements.SpriteViewer;
import com.l08gr02.zelda.viewers.elements.tiles.HeartViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class SpriteViewerTest {
    private GUI gui;
    private Heart heart;
    private SpriteViewer spriteViewer;
    private TextGraphics tg;

    @BeforeEach
    void setup() throws URISyntaxException, IOException, FontFormatException {
        heart = new Heart(10,10);
        spriteViewer = new HeartViewer();
        gui = Mockito.mock(GUI.class);
        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(gui.getGraphics()).thenReturn(tg);
    }

    @Test
    void drawTest(){
        spriteViewer.drawt(gui, heart);
        Mockito.verify(tg, Mockito.times(108)).setBackgroundColor(Mockito.any());
        Mockito.verify(tg, Mockito.times(1)).setCharacter(12,15,' ');
    }
}
