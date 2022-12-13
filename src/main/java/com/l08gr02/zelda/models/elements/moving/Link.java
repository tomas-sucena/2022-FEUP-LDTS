package com.l08gr02.zelda.models.elements.moving;

import com.l08gr02.zelda.models.elements.Hitbox;

public class Link extends Fighter {
    private static int WALK_SPEED = 2, SPRINT_SPEED = 4;

    // constructor
    public Link(int x, int y){
        super(x, y);
        setHitbox(new Hitbox(x + 15, y + 24, 14, 10));

        setHearts(3);
    }

    // methods
    @Override
    public void attack() {
    }

    public void walk(){
        setSpeed(WALK_SPEED);
    }

    public void sprint(){
        setSpeed(SPRINT_SPEED);
    }

}
