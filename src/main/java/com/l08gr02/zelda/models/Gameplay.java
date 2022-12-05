package com.l08gr02.zelda.models;

import com.l08gr02.zelda.models.dungeon.Dungeon;

import java.io.IOException;

public class Gameplay {
    private Dungeon dungeon;

    // constructor
    public Gameplay() throws IOException {
        dungeon = new Dungeon();
    }

    // methods
    public Dungeon getDungeon() {
        return dungeon;
    }
}
