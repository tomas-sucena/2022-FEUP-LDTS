package com.l08gr02.zelda.presenters.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.l08gr02.zelda.models.elements.Tile;
import com.l08gr02.zelda.presenters.Presenter;
import com.l08gr02.zelda.viewers.elements.TileViewer;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class TilePresenter extends Presenter<Tile> {
    // constructor
    public TilePresenter(Tile model, TileViewer viewer){
        super(model, viewer);
    }

    // method
    @Override
    public void update(TextGraphics graphics, ACTION action) {
        viewer.draw(graphics, model);
    }
}
