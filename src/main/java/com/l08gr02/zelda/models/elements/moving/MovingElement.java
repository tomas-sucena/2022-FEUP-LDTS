package com.l08gr02.zelda.models.elements.moving;

import com.l08gr02.zelda.models.elements.Element;

public abstract class MovingElement extends Element {
    protected int speed;
    protected boolean colliding;

    // constructors
    public MovingElement(int x, int y){
        super(x, y);
    }

    // methods
    public int getSpeed(){
        return speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public boolean canMove(){
        return !colliding;
    }

    public void collides(MovingElement mv){
        colliding = this.hitbox.intersects(mv.hitbox);
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
