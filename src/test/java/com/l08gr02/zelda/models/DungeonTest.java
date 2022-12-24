package com.l08gr02.zelda.models;

import com.l08gr02.zelda.models.dungeon.Dungeon;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DungeonTest {
    @Test
    void DungeonTest() throws IOException {
        Dungeon dungeon = new Dungeon();

        // Testing map creation
        assertEquals(128, dungeon.getLink().getPosition().getX());
        assertEquals(48, dungeon.getLink().getPosition().getY());
        assertEquals(0, dungeon.getTiles().get(0).getPosition().getX());
        assertEquals(0, dungeon.getTiles().get(0).getPosition().getY());
        assertEquals(4 * 16, dungeon.getHearts().get(0).getPosition().getX());
        assertEquals(16, dungeon.getHearts().get(0).getPosition().getY());
    }
}
