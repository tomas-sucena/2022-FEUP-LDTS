package com.l08gr02.zelda.Presenter;

import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.models.elements.moving.Link;
import com.l08gr02.zelda.models.elements.moving.monsters.Log;
import com.l08gr02.zelda.models.elements.moving.monsters.Monster;
import com.l08gr02.zelda.presenters.dungeon.DungeonPresenter;
import com.l08gr02.zelda.viewers.dungeon.DungeonViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ColisionTest {


    @Test
    void LinkCollisionTest(){
        Monster monster = new Log(10,10);
        Link link = new Link(9,9);
        assertTrue(link.collidesWith(monster));
    }

}
