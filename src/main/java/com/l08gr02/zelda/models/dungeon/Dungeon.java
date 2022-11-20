package com.l08gr02.zelda.models.dungeon;

import com.l08gr02.zelda.models.elements.Link;

public class Dungeon {
    private Link link;

    // constructor
    public Dungeon(){
        link = new Link(200, 80);
    }

    // methods
    public Link getLink() {
        return link;
    }
}
