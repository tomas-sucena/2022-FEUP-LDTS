package com.l08gr02.zelda.viewers.elements;

import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.tiles.StaticTile;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.viewers.SpriteViewer;

public class StaticTileViewer extends SpriteViewer<StaticTile> {

    public StaticTileViewer(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void setSprite(GameplayPresenter.ACTION action) {

    }
}
