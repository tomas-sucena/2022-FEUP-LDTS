package com.l08gr02.zelda.models.elements.actions;

import com.l08gr02.zelda.models.elements.CollidingElement;

import java.util.List;

public interface Collision {
    List<CollidingElement> getObstacles();
    void setObstacles(List<CollidingElement> obstacles);
}
