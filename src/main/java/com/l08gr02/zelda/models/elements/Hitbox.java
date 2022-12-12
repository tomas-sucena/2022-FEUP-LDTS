package com.l08gr02.zelda.models.elements;

import java.awt.*;

public class Hitbox extends Rectangle {
    // constructor
    public Hitbox(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    // method
    public Hitbox up(int i){
        return new Hitbox(x, y - i, width, height);
    }

    public Hitbox down(int i){
        return new Hitbox(x, y + i, width, height);
    }

    public Hitbox left(int i){
        return new Hitbox(x - i, y, width, height);
    }

    public Hitbox right(int i){
        return new Hitbox(x + i, y, width, height);
    }

}
