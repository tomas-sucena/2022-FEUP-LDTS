package com.l08gr02.zelda.models.elements;

public class Link extends MovingElement {
    // constructor
    public Link(int x, int y){
        super(x, y);
        hearts = 3;
    }

    // methods
    @Override
    public void attack() {
    }
}
