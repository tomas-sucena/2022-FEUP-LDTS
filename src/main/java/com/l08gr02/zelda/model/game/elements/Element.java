package com.l08gr02.zelda.model.game.elements;

import com.l08gr02.zelda.model.Position;

public class Element {
    private Position pos;

    // constructor
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
