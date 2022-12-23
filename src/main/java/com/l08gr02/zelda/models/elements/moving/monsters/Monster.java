package com.l08gr02.zelda.models.elements.moving.monsters;


import com.l08gr02.zelda.models.elements.moving.Creature;

public abstract class Monster extends Creature {
    protected int WALK_SPEED;

    // constructor
    public Monster(int x, int y){
        super(x, y);
    }

}
