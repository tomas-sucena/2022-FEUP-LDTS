package com.l08gr02.zelda.Viewers;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.gui.LanternaGUI;
import com.l08gr02.zelda.models.elements.tiles.Heart;
import com.l08gr02.zelda.viewers.elements.HeartViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class HeartViewerTest {
    private GUI gui;
    private Heart heart;
    private HeartViewer heartViewer;

    @BeforeEach
    void setup(){
        heart = Mockito.mock(Heart.class);
        heartViewer = Mockito.mock(HeartViewer.class);
        gui = Mockito.mock(GUI.class);
    }
    @Test
    void drawTest(){
        heartViewer.draw(gui,heart);
        Mockito.verify(heartViewer,Mockito.times(1)).draw(gui, heart);
    }
}
