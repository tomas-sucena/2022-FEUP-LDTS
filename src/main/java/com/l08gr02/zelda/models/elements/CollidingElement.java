package com.l08gr02.zelda.models.elements;

import com.l08gr02.zelda.models.elements.actions.Collision;

import java.util.LinkedList;
import java.util.List;

public abstract class CollidingElement extends Element implements Collision {
    private List<CollidingElement> obstacles;

    // construtor
    public CollidingElement(int x, int y){
        super(x, y);

        obstacles = new LinkedList<>();
    }

    // métodos
    public List<CollidingElement> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<CollidingElement> obstacles) {
        this.obstacles = obstacles;
    }

}
