package com.l08gr02.zelda.models.elements.tiles;

import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.Element;
import com.l08gr02.zelda.models.elements.Hitbox;

import java.awt.*;

public abstract class Tile extends Element {
    protected Sprite sprite;

    // constructor
    public Tile(int x, int y, char c) {
        super(x, y);
        setHitbox(new Hitbox(x, y, 16, 16));

        sprite = new Sprite(16,16,"Dungeon", "Overworld");
        switch(c){
            case ' ' -> {sprite.setPixels(0,0);}

            case 'B' -> {sprite.setPixels(20,20);}
        }
    }

    // method
    public Sprite getSprite() {
        return sprite;
    }
}
