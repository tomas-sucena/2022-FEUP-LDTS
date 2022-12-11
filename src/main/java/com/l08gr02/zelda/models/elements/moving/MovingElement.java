package com.l08gr02.zelda.models.elements.moving;

import com.l08gr02.zelda.models.elements.Element;

public abstract class MovingElement extends Element {
    protected float hearts;
    protected int speed;

    // constructors
    public MovingElement(int x, int y){
        super(x, y);
    }

    // methods
    public float getHearts(){
        return hearts;
    }

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

    public void takeDamage(float heartsLost) {
        hearts -= heartsLost;
    }

    public void heal(float heartsGained) {
        hearts += heartsGained;
    }

    public abstract void attack();

}
