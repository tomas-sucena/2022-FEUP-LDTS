package com.l08gr02.zelda.models.dungeon;

import com.l08gr02.zelda.models.elements.Link;
import com.l08gr02.zelda.models.elements.Monster;

import java.util.List;
import java.util.Random;

public class Dungeon {
    private Link link;
    private List<Monster> monsters;

    // constructor
    public Dungeon(){
        link = new Link(200, 80);
        //spawnMonsters();
    }

    // methods
    public Link getLink() {
        return link;
    }

    public void spawnMonsters(){
        Random rand = new Random();

        for (int i = 0; i < 4; i++){
            monsters.add(new Monster(rand.nextInt(400),
                                     rand.nextInt(160)));
        }
    }

}
