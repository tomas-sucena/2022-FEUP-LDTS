package com.l08gr02.zelda.models.elements.moving.monsters;

import com.l08gr02.zelda.models.elements.Hitbox;

public class Log extends Monster {
    private Hitbox attackZone;

    // constructor
    public Log(int x, int y){
        super(x, y);
        setHitbox(new Hitbox(x + 8, y + 12, 16, 16));
        attackZone = new Hitbox(x - 8, y - 8, 48, 48);

        // define the stats
        setHearts(2);
        WALK_SPEED = 3;

        setSpeed(WALK_SPEED);
    }

    // methods
    @Override
    public void attack() {
    }

}
