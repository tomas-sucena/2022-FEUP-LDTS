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
}
