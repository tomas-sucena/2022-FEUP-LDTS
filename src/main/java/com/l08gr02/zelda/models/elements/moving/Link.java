package com.l08gr02.zelda.models.elements.moving;

import com.l08gr02.zelda.models.elements.Hitbox;

public class Link extends Fighter {
    private static int WALK_SPEED = 2, SPRINT_SPEED = 4;

    // constructor
    public Link(int x, int y){
        super(x, y);
        hitbox = new Hitbox(x + 15, y + 24, 14, 10);
        biggerHitbox = new Hitbox(x + 10, y + 12, 24, 24);

        hearts = 3;
        speed = WALK_SPEED;
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
