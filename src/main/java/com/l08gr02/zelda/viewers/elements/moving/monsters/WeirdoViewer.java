package com.l08gr02.zelda.viewers.elements.moving.monsters;

import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.moving.monsters.Weirdo;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class WeirdoViewer extends MonsterViewer<Weirdo> {
    // constructor
    public WeirdoViewer(){
        super(new Sprite(24, 24, "monsters", "weirdo"));
    }

    // methods
    @Override
    public void setSprite(ACTION action) {
        switch (action) {
            case UP -> yGrid = 2;

            case DOWN -> yGrid = 0;

            case LEFT -> yGrid = 3;

            case RIGHT -> yGrid = 1;
        }

        xGrid = (xGrid >= 3) ? 0 : xGrid + 1;

        sprite.setPixels(xGrid, yGrid);
    }

}
