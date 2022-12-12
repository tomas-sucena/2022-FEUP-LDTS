package com.l08gr02.zelda.models.elements;

import com.l08gr02.zelda.models.elements.actions.Collision;

import java.util.ArrayList;
import java.util.List;

public abstract class CollidingElement extends Element implements Collision {
    protected Hitbox hitbox;
    private List<CollidingElement> obstacles;

    // constructors
    public CollidingElement(int x, int y){
        super(x, y);

        obstacles = new ArrayList<>();
    }

    // methods
    public Hitbox getHitbox() {
        return hitbox;
    }

    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }

    public List<CollidingElement> getObstacles() {
        return obstacles;
    }

    public void addObstacle(CollidingElement el){
        obstacles.add(el);
    }

    public void resetObstacles(){
        obstacles.clear();
    }

}
