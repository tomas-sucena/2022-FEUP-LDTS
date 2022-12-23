package com.l08gr02.zelda.Viewers;

import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.elements.tiles.Heart;
import com.l08gr02.zelda.viewers.elements.tiles.HeartViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
