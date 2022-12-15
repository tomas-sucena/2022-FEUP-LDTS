package com.l08gr02.zelda.models.elements.moving.monsters;


import com.l08gr02.zelda.models.elements.moving.Fighter;

import java.util.LinkedList;
import java.util.List;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public abstract class Monster extends Fighter {
    protected static int WALK_SPEED;
    protected int actionLockCounter;
    protected List<ACTION> actions = new LinkedList<>();

    // construtor
    public Monster(int x, int y){
        super(x, y);

        actionLockCounter = 0;
    }

    // métodos
    public List<ACTION> getactions(){
        return actions;
    }

    @Override
    public abstract void attack();
}
