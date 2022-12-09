package com.l08gr02.zelda.models.elements;



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
        Position newpos;
        while(true){
            newpos = this.getPosition().getRandomNeighbour();
            if(newpos.isEmpty()) break;
        }
        this.setPosition(newpos);
    }
}
