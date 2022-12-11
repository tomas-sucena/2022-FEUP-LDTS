package com.l08gr02.zelda.models.elements;

import com.l08gr02.zelda.models.elements.actions.Collision;

public abstract class CollidingElement extends Element implements Collision {
    protected Hitbox hitbox;
    private boolean colliding;

    // constructor
    public CollidingElement(int x, int y){
        super(x, y);
    }

    // method
    public Hitbox getHitbox() {
        return hitbox;
    }

    public boolean isColliding() {
        return colliding;
    }

    public void setColliding(boolean colliding) {
        this.colliding = colliding;
    }

    public boolean collides(CollidingElement el){
        return hitbox.intersects(el.getHitbox());
    }

}
