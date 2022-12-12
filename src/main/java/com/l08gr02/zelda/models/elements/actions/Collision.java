package com.l08gr02.zelda.models.elements.actions;

import com.l08gr02.zelda.models.elements.CollidingElement;
import com.l08gr02.zelda.models.elements.Hitbox;

import java.util.List;

public interface Collision {
    Hitbox getHitbox();
    void setHitbox(Hitbox hitbox);
    List<CollidingElement> getObstacles();
    void addObstacle(CollidingElement el);
    void resetObstacles();
}
