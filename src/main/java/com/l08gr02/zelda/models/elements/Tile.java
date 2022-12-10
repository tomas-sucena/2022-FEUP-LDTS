package com.l08gr02.zelda.models.elements;

import com.l08gr02.zelda.models.Sprite;

import java.awt.*;

public abstract class Tile extends Element {
    protected Sprite sprite;

    // constructor
    public Tile(int x, int y, char c) {
        super(x, y);
        sprite = new Sprite(16,16,"Dungeon", "Overworld");
        switch(c){
            case 'd' -> {sprite.setPixels(0,0);}

        }
    }

    // method
    public Sprite getSprite() {
        return sprite;
    }
}
