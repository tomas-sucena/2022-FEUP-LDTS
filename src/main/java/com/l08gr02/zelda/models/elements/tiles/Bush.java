package com.l08gr02.zelda.models.elements.tiles;

import com.l08gr02.zelda.models.elements.CollidingElement;
import com.l08gr02.zelda.models.elements.Hitbox;

public class Bush extends CollidingElement {
    private char c;

    // constructor
    public Bush(int x, int y, char c) {
        super(x, y);
        setHitbox(new Hitbox(x, y, 16, 16));

        this.c = c;
    }

    // methods
    public char getC() {
        return c;
    }
}
