package com.l08gr02.zelda.viewers.elements.moving.monsters;

import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.moving.monsters.Weirdo;
import com.l08gr02.zelda.presenters.GameplayPresenter;

public class WeirdoViewer extends MonsterViewer<Weirdo> {
    // constructor
    public WeirdoViewer(){
        super(new Sprite(32, 32, "monsters", "weirdo"));
    }

    // methods
    @Override
    public void setSprite(GameplayPresenter.ACTION action) {
        switch (action) {
            case UP -> yGrid = 1;

            case DOWN -> yGrid = 0;

            case LEFT -> yGrid = 3;

            case RIGHT -> yGrid = 2;
        }

        xGrid = (xGrid >= 3) ? 0 : xGrid + 1;

        sprite.setPixels(xGrid, yGrid);
    }

}
