package com.l08gr02.zelda.models.elements;

import java.util.Random;

public class Monster extends MovingElement {
    // constructor
    public Monster(int x, int y){
        super(x, y);
        hearts = 2;
    }

    // methods
    @Override
    public void attack() {
    }

    public void sleep(){
    }

    public void move(){
        Random rnd = new Random();
        while(true){
            int genMove = rnd.nextInt(4);
            Position newpos = new Position(this.getPosition());
            switch(genMove){
                case 0:
                    newpos.up(1);
                    break;
                case 1:
                    newpos.down(1);
                    break;
                case 2:
                    newpos.left(1);
                    break;
                case 3:
                    newpos.right(1);
                    break;
            }
            if(checkValidMove(newpos)){
                setPosition(newpos);
            }
        }
    }
}
