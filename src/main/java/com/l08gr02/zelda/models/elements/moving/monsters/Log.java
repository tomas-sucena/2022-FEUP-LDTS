package com.l08gr02.zelda.models.elements.moving.monsters;

import com.l08gr02.zelda.models.elements.Hitbox;
import com.l08gr02.zelda.presenters.GameplayPresenter;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Log extends Monster {
    // construtor
    public Log(int x, int y){
        super(x, y);
        setHitbox(new Hitbox(x, y, 32, 32));

        // definir os stats
        setHearts(2);
        WALK_SPEED = 1;

        setSpeed(WALK_SPEED);
    }

    // métodos
    @Override
    public void attack() {
    }

    public void move(){
        actionLockCounter++;

        List<GameplayPresenter.ACTION> actions = new LinkedList<>();
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
