package com.l08gr02.zelda.model.game.elements;

public abstract class MovingElement extends Element {
    // constructor
    MovingElement(int x, int y){
        super(x, y);
    }

    // methods
    public void moveUp(int i){
        this.setPosition(getPosition().up(i));
    }

    public void moveDown(int i){
        this.setPosition(getPosition().down(i));
    }

    public void moveLeft(int i){
        this.setPosition(getPosition().left(i));
    }

    public void moveRight(int i){
        this.setPosition(getPosition().right(i));
    }
}
