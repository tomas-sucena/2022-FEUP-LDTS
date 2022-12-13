package com.l08gr02.zelda.models.elements.moving;


import com.l08gr02.zelda.models.elements.Hitbox;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static com.l08gr02.zelda.presenters.GameplayPresenter.ACTION;

public class Monster extends Fighter {
    private static int WALK_SPEED = 1;
    private int actionLockCounter=0;
    private List<ACTION> actions = new LinkedList<>();

    // construtor
    public Monster(int x, int y){
        super(x, y);
        setHitbox(new Hitbox(x, y, 32, 32));

        setHearts(2);
        setSpeed(WALK_SPEED);
    }

    // métodos
    @Override
    public void attack() {
    }

    public void sleep(){
    }

    public List<ACTION> getactions(){
        return actions;
    }

    public void move(){
        actionLockCounter++;

        List<ACTION> actions = new LinkedList<>();
        if(actionLockCounter>120){
            Random rnd = new Random();
            int genMove = rnd.nextInt(4);
            switch(genMove){
                case 0 -> actions.add(ACTION.UP);
                case 1 -> actions.add(ACTION.DOWN);
                case 2 -> actions.add(ACTION.LEFT);
                case 3 -> actions.add(ACTION.RIGHT);
            }

            actionLockCounter=0;
        }
    }

}
