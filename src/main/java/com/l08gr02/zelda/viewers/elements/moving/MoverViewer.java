package com.l08gr02.zelda.viewers.elements.moving;

import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.moving.Mover;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.viewers.elements.SpriteViewer;

public abstract class MoverViewer<T extends Mover> extends SpriteViewer<T> {
    protected int xGrid = 0, yGrid = 0;

    // constructor
    public MoverViewer(Sprite sprite) {
        super(sprite);
    }

    // method
    public abstract void setSprite(GameplayPresenter.ACTION action);
}
