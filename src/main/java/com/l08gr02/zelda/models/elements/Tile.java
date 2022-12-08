package com.l08gr02.zelda.models.elements;

import com.l08gr02.zelda.models.Sprite;

import java.awt.*;

public class Tile extends Element{
    private Sprite sprite;
    public Tile(int x, int y, char c) {
        super(x, y);
        sprite = new Sprite(16,16,"Dungeon", "Overworld");
        switch(c){
            case 'd' -> {sprite.setPixels(0,0);}
        }
    }

    public Sprite getSprite() {
        return sprite;
    }
}