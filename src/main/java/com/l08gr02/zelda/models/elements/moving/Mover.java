package com.l08gr02.zelda.models.elements.moving;

import com.l08gr02.zelda.models.elements.CollidingElement;
import com.l08gr02.zelda.models.elements.Hitbox;
import com.l08gr02.zelda.models.elements.actions.Movement;

public abstract class Mover extends CollidingElement implements Movement {
    private int speed;
    protected Hitbox biggerHitbox; // usada para filtrar os objetos com que os Fighters colidem

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

    public Hitbox getBiggerHitbox() {
        return biggerHitbox;
    }

    public void setBiggerHitbox(Hitbox biggerHitbox) {
        this.biggerHitbox = biggerHitbox;
    }

    public void up(int i){
        setPosition(getPosition().up(i));

        // mover as hitboxes
        setHitbox(getHitbox().up(i));
        setBiggerHitbox(getBiggerHitbox().up(i));
    }

    public void down(int i){
        setPosition(getPosition().down(i));

        // mover as hitboxes
        setHitbox(getHitbox().down(i));
        setBiggerHitbox(getBiggerHitbox().down(i));
    }

    public void left(int i){
        setPosition(getPosition().left(i));

        // mover as hitboxes
        setHitbox(getHitbox().left(i));
        setBiggerHitbox(getBiggerHitbox().left(i));
    }

    public void right(int i){
        setPosition(getPosition().right(i));

        // mover as hitboxes
        setHitbox(getHitbox().right(i));
        setBiggerHitbox(getBiggerHitbox().right(i));
    }
}
