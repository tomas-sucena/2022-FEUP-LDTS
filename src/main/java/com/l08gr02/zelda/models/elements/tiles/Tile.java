package com.l08gr02.zelda.models.elements.tiles;

import com.l08gr02.zelda.models.Sprite;
import com.l08gr02.zelda.models.elements.CollidingElement;
import com.l08gr02.zelda.models.elements.Hitbox;

public abstract class Tile extends CollidingElement {
    protected Sprite sprite;
    private char c;
    private boolean collision;

    // constructor
    public Tile(int x, int y, char c) {
        super(x, y);
        setHitbox(new Hitbox(x, y, 16, 16));

        this.c = c;

        sprite = new Sprite(16,16,"Dungeon", "Overworld");
        switch(c){
            case ' ' -> {
                sprite.setPixels(0,0);
                collision = false;
            }

            case 'B' -> {
                sprite.setPixels(2,14);
                collision = true;
                setHitbox(new Hitbox(x, y, 10, 10));
            }
        }
    }

    // method
    public char getChar() {
        return c;
    }

    public boolean isCollidable() {
        return collision;
    }

    public Sprite getSprite() {
        return sprite;
    }
}
