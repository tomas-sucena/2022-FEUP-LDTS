package com.l08gr02.zelda.models.elements.moving.monsters;


import com.l08gr02.zelda.models.elements.moving.Fighter;

public abstract class Monster extends Fighter {
    protected static int WALK_SPEED;

    // constructor
    public Monster(int x, int y){
        super(x, y);
    }

    // methods
    @Override
    public abstract void attack();
}
