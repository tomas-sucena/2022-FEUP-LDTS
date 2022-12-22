package com.l08gr02.zelda.models;

import com.l08gr02.zelda.models.dungeon.Dungeon;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DungeonTest {
    //Sussy baka depois preciso que testes e corrigas isto, desculpa my path sucks
    @Test
    void DungeonTest() throws IOException {
        Dungeon dungeon = new Dungeon();
        assertEquals(dungeon.getLink().getPosition().getX(),80);
        assertEquals(dungeon.getLink().getPosition().getY(),32);
        assertEquals(dungeon.getStiles().get(0).getPosition().getX(),0);
        assertEquals(dungeon.getStiles().get(0).getPosition().getY(),0);
        assertEquals(dungeon.getAtiles().get(0).getPosition().getX(),12*16);
        assertEquals(dungeon.getAtiles().get(0).getPosition().getY(),4*16);
        assertEquals(dungeon.getHearts().get(0).getPosition().getX(),5*16);
        assertEquals(dungeon.getHearts().get(0).getPosition().getY(),2*16);
    }
}
