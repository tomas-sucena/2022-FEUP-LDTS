package com.l08gr02.zelda;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.presenters.Presenter;
import com.l08gr02.zelda.presenters.dungeon.DungeonPresenter;
import com.l08gr02.zelda.viewers.dungeon.DungeonViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PresenterTest {
    private Presenter presenter;
    private TextGraphics graphics;

    @Test
    void DungeonPresenterTest(){
        // ARRANGE
        Dungeon model = new Dungeon();
        DungeonViewer viewer = new DungeonViewer(400,160;

        presenter = new DungeonPresenter(model, viewer);
        graphics = Mockito.mock(TextGraphics.class);

        // ACT
        presenter.update(graphics, GameplayPresenter.ACTION.NOTHING);

        // ASSERT
        Mockito.verify(graphics.setBackgroundColor(TextColor.Factory.fromString("#336699")), Mockito.times(1));
    }

}
