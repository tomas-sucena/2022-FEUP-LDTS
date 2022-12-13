package com.l08gr02.zelda.models.elements.moving;


import com.l08gr02.zelda.presenters.GameplayPresenter;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Monster extends Fighter {
    private static int WALK_SPEED=1;
    private int actionLockCounter=0;
    public List<GameplayPresenter.ACTION> actions = new LinkedList<>();

    // construtor
    public Monster(int x, int y){
        super(x, y);
        hearts = 2;
        speed = WALK_SPEED;
    }

    // métodos
    @Override
    public void attack() {
    }

    public void sleep(){
    }

    public List<GameplayPresenter.ACTION> getactions(){
        return actions;
    }

    public void move(){
        actionLockCounter++;
        if(actionLockCounter>120){
            Random rnd = new Random();
            int genMove = rnd.nextInt(4);
            switch(genMove){
                case 0 -> actions.add(GameplayPresenter.ACTION.UP);
                case 1 -> actions.add(GameplayPresenter.ACTION.DOWN);
                case 2 -> actions.add(GameplayPresenter.ACTION.LEFT);
                case 3 -> actions.add(GameplayPresenter.ACTION.RIGHT);
            }
            actionLockCounter=0;
        }
    }
}
