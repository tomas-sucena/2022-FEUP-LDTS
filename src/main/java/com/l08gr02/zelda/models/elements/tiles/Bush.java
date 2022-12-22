package com.l08gr02.zelda.models.elements.tiles;

import com.l08gr02.zelda.models.elements.CollidingElement;
import com.l08gr02.zelda.models.elements.Hitbox;

public class Bush extends CollidingElement {
    // constructor
    public Bush(int x, int y) {
        super(x, y);
        setHitbox(new Hitbox(x, y, 16, 16));
    }
}
