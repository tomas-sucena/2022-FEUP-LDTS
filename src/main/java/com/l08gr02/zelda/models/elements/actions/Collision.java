package com.l08gr02.zelda.models.elements.actions;

import com.l08gr02.zelda.models.elements.CollidingElement;

public interface Collision {
    boolean collidesWith(CollidingElement e);
}
