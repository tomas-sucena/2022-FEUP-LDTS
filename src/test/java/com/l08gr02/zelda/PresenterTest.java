package com.l08gr02.zelda;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.presenters.Presenter;
import com.l08gr02.zelda.presenters.dungeon.DungeonPresenter;
import com.l08gr02.zelda.viewers.dungeon.DungeonViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PresenterTest {
    private Presenter presenter;
    private TextGraphics graphics;

    @Test
    void DungeonPresenterTest() throws IOException {
        /*
        // ARRANGE
        Dungeon model = new Dungeon();
        DungeonViewer viewer = new DungeonViewer(400,160);

        presenter = new DungeonPresenter(model, viewer);
        graphics = Mockito.mock(TextGraphics.class);

        // ACT
        //presenter.update(graphics, GameplayPresenter.ACTION.NOTHING);

        // ASSERT
        Mockito.verify(graphics.setBackgroundColor(TextColor.Factory.fromString("#336699")), Mockito.times(1));
        Mockito.verify(graphics.fillRectangle(new TerminalPosition(0, 0),new TerminalSize(400, 160), ' '), Mockito.times(1));
        */
    }

}
