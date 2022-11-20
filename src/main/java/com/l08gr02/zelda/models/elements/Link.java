package com.l08gr02.zelda.models.elements;

public class Link extends MovingElement {
    private float hearts = 3;

    // constructor
    public Link(int x, int y){
        super(x, y);
    }

    // methods
    public float getHearts(){
        return hearts;
    }

    public void takeDamage(float heartsLost) {
        hearts -= heartsLost;
    }
}
