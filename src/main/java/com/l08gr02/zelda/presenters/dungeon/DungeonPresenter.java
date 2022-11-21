package com.l08gr02.zelda.presenters.dungeon;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.presenters.Presenter;
import com.l08gr02.zelda.presenters.elements.LinkPresenter;
import com.l08gr02.zelda.viewers.dungeon.DungeonViewer;

public class DungeonPresenter extends Presenter<Dungeon> {
    private LinkPresenter linkPresenter;

    // constructor
    public DungeonPresenter(Dungeon model, DungeonViewer viewer) {
        super(model, viewer);

        linkPresenter = new LinkPresenter(model.getLink(), viewer.getLinkViewer());
    }

    // methods
    @Override
    public void update(Screen screen, GameplayPresenter.ACTION action){
        viewer.draw(screen, model);
        linkPresenter.update(screen, action);
    }
}
