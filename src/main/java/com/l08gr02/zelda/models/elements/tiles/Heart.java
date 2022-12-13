package com.l08gr02.zelda.models.elements.tiles;

import com.l08gr02.zelda.models.elements.CollidingElement;
import com.l08gr02.zelda.models.elements.Hitbox;

public class Heart extends CollidingElement {
    public Heart(int x, int y) {
        super(x, y);
        setHitbox(new Hitbox(x, y, 16, 16));
    }
}
