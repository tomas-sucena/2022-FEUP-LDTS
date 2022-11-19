package com.l08gr02.zelda.model.game.map;

import com.l08gr02.zelda.model.game.elements.Link;

public class Map {
    private final int width, height; // largura e altura
    private Link link;

    // constructor
    public Map(int width, int height, Link link){
        this.width = width; this.height = height;
        this.link = link;
    }

    // methods
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Link getLink() {
        return link;
    }
}
