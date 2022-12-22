package com.l08gr02.zelda.Viewers;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.elements.moving.Link;
import com.l08gr02.zelda.models.elements.tiles.Heart;
import com.l08gr02.zelda.viewers.elements.HeartViewer;
import com.l08gr02.zelda.viewers.elements.LinkViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class LinkViewerTest {
    private GUI gui;
    private Link link;
    private LinkViewer linkViewer;
    private TextGraphics tg;

    @BeforeEach
    void setup() throws URISyntaxException, IOException, FontFormatException {
        link = new Link(10,10);
        linkViewer = Mockito.mock(LinkViewer.class);
        gui = Mockito.mock(GUI.class);
        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(gui.getGraphics()).thenReturn(tg);
    }
    @Test
    void drawTest(){
        linkViewer.draw(gui,link);
        Mockito.verify(linkViewer,Mockito.times(1)).draw(Mockito.any(), Mockito.any());
    }
}
