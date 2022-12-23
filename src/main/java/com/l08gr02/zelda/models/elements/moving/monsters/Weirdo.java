package com.l08gr02.zelda.models.elements.moving.monsters;

import com.l08gr02.zelda.models.elements.Hitbox;

public class Weirdo extends Monster {
    // constructor
    public Weirdo(int x, int y){
        super(x, y);
        setHitbox(new Hitbox(x + 8, y + 12, 16, 16));

        // define the stats
        setHearts(3);
        WALK_SPEED = 2;

        setSpeed(WALK_SPEED);
    }

}
