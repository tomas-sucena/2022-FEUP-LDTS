package com.l08gr02.zelda.models.elements.moving;

import com.l08gr02.zelda.models.elements.CollidingElement;
import com.l08gr02.zelda.models.elements.actions.Movement;

public abstract class Mover extends CollidingElement implements Movement {
    private int speed;

    // constructor
    public Mover(int x, int y) {
        super(x, y);
    }

    // methods
    public int getSpeed(){
        return speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public void up(int i){
        setPosition(getPosition().up(i));
        hitbox.y -= i;
    }

    public void down(int i){
        setPosition(getPosition().down(i));
        hitbox.y += i;
    }

    public void left(int i){
        setPosition(getPosition().left(i));
        hitbox.x -= i;
    }

    public void right(int i){
        setPosition(getPosition().right(i));
        hitbox.x += i;
    }
}
