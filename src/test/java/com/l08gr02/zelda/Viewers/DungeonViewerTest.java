package com.l08gr02.zelda.Viewers;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.models.elements.tiles.Heart;
import com.l08gr02.zelda.viewers.dungeon.DungeonViewer;
import com.l08gr02.zelda.viewers.elements.HeartViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class DungeonViewerTest {
    private GUI gui;
    private Dungeon dungeon;
    private DungeonViewer dungeonViewer;
    private TextGraphics tg;

    @BeforeEach
    void setup() throws URISyntaxException, IOException, FontFormatException {
        dungeon = new Dungeon();
        dungeonViewer = Mockito.mock(DungeonViewer.class);
        gui = Mockito.mock(GUI.class);
        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(gui.getGraphics()).thenReturn(tg);
    }
    @Test
    void drawTest(){
        dungeonViewer.draw(gui,dungeon);
        Mockito.verify(dungeonViewer,Mockito.times(1)).drawStaticTiles(Mockito.any(), Mockito.any());
        Mockito.verify(dungeonViewer,Mockito.times(1)).drawHearts(Mockito.any(), Mockito.any());
        Mockito.verify(dungeonViewer,Mockito.times(1)).drawAnimatedTiles(Mockito.any(), Mockito.any());
    }
}
