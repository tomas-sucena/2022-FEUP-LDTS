package com.l08gr02.zelda.models;

import com.l08gr02.zelda.models.dungeon.Dungeon;

public class Gameplay {
    private Dungeon dungeon;

    // constructor
    public Gameplay(){
        dungeon = new Dungeon();
    }

    // methods
    public Dungeon getDungeon() {
        return dungeon;
    }
}
