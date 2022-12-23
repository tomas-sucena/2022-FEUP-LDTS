package com.l08gr02.zelda.Viewers;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.gui.GUI;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.viewers.dungeon.DungeonViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class DungeonViewerTest {
    //Sussy baka depois preciso que testes e corrigas isto, desculpa my path sucks
    private GUI gui;
    private Dungeon dungeon;
    private DungeonViewer dungeonViewer;
    private TextGraphics tg;

    @BeforeEach
    void setup() throws IOException {
        dungeon = new Dungeon();
        dungeonViewer = new DungeonViewer();
        gui = Mockito.mock(GUI.class);
        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(gui.getGraphics()).thenReturn(tg);
    }
    @Test
    void GrassdrawTest(){
        dungeonViewer.draw(gui,dungeon);
        //Grass
        Mockito.verify(tg,Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#6ADD4B")); //Deve estar a dar, nao sei se o numero esta certo though
        Mockito.verify(tg,Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#3ABE41")); //Mesma coisa
        Mockito.verify(tg,Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#29973B")); //Mesma coisa

        //Brush
        Mockito.verify(tg,Mockito.times(1)).setBackgroundColor(Mockito.any());
    }
    @Test
    void BrushdrawTest(){
        dungeonViewer.draw(gui,dungeon);
        Mockito.verify(tg,Mockito.times(1)).setBackgroundColor(Mockito.any());
        Mockito.verify(tg, Mockito.times(1)).setCharacter(2,7,' ');
    }
}
