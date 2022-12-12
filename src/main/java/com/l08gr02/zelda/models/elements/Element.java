package com.l08gr02.zelda.models.elements;

public abstract class Element {
    private Position pos;

    // constructors
    public Element(int x, int y){
        pos = new Position(x, y);
    }

    // methods
    public Position getPosition(){
        return pos;
    }

    public void setPosition(Position pos){
        this.pos = pos;
    }

}
