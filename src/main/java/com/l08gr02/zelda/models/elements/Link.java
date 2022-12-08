package com.l08gr02.zelda.models.elements;

public class Link extends MovingElement {
    private static int WALK_SPEED = 1, SPRINT_SPEED = 3;

    // constructor
    public Link(int x, int y){
        super(x, y);
        hearts = 3;
        speed = WALK_SPEED;
    }

    // methods
    @Override
    public void attack() {
    }

    public void walk(){
        setSpeed(WALK_SPEED);
    }

    public void sprint(){
        setSpeed(SPRINT_SPEED);
    }

}
