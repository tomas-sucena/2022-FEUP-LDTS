package com.l08gr02.zelda.Viewers;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.gui.Camera;
import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.models.elements.Position;
import com.l08gr02.zelda.viewers.dungeon.DungeonViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class DungeonViewerTest {
    //Sussy baka depois preciso que testes e corrigas isto, desculpa my path sucks
    private GUI gui;
    private Camera camera;
    private Dungeon dungeon;
    private DungeonViewer dungeonViewer;
    private TextGraphics tg;

    @BeforeEach
    void setup() throws IOException {
        dungeon = new Dungeon();
        dungeonViewer = new DungeonViewer();

        gui = Mockito.mock(GUI.class);
        camera = Mockito.mock(Camera.class);
        Mockito.when(gui.getCamera()).thenReturn(camera);
        Mockito.when(camera.getPosition()).thenReturn(new Position(0, 0));

        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(gui.getGraphics()).thenReturn(tg);
    }
    @Test
    void GrassdrawTest(){
        dungeonViewer.draw(gui, dungeon);
        //Grass
        Mockito.verify(tg,Mockito.times(3102)).setBackgroundColor(TextColor.Factory.fromString("#6ADD4B"));
        Mockito.verify(tg,Mockito.times(1034)).setBackgroundColor(TextColor.Factory.fromString("#3ABE41"));
        Mockito.verify(tg,Mockito.times(3102)).setBackgroundColor(TextColor.Factory.fromString("#29973B"));
    }
}
