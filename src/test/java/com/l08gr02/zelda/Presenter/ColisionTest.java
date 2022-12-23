package com.l08gr02.zelda.Presenter;

import com.l08gr02.zelda.models.dungeon.Dungeon;
import com.l08gr02.zelda.models.elements.moving.Link;
import com.l08gr02.zelda.models.elements.moving.monsters.Log;
import com.l08gr02.zelda.models.elements.moving.monsters.Monster;
import com.l08gr02.zelda.models.elements.tiles.Heart;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import com.l08gr02.zelda.presenters.dungeon.DungeonPresenter;
import com.l08gr02.zelda.viewers.dungeon.DungeonViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertTrue;




import static org.junit.jupiter.api.Assertions.*;

public class ColisionTest {

    private Dungeon dungeon;
    private DungeonViewer dungeonViewer;
    private DungeonPresenter dungeonPresenter;

    @BeforeEach
    void setup() throws IOException {
        dungeon = new Dungeon();
        dungeonViewer = new DungeonViewer();
        dungeonPresenter = new DungeonPresenter(dungeon,dungeonViewer);
    }

    @Test
    void LinkCollisionTest(){
        Monster monster = new Log(10,10);
        Link link = new Link(9,9);
        assertTrue(link.collidesWith(monster));
    }


    @Test
    void swordCollisionTest() throws IOException {
        Monster monster = new Log(10, 30);
        dungeon.setLink(new Link(10,10));
        dungeon.getMonsters().add(monster);
        dungeonPresenter.checkCollisions();
        assertEquals(1, monster.getHearts());
        assertEquals(10,monster.getPosition().getX());
        assertEquals(30+16, monster.getPosition().getY());

    }

    @Test
    void HeartCollisionTest() throws IOException {
        dungeon.setLink(new Link(10,10));
        Heart heart = new Heart(12,12);
        dungeonPresenter.getModel().getHearts().add(heart);
        dungeonPresenter.checkLinkCollisions();
        assertEquals(4.0f ,dungeon.getLink().getHearts());
        assertFalse(dungeon.getHearts().contains(heart));

    }

    @Test
    void MonsterCollisionTest(){
        Monster m1 = new Log(16, 16);
        Monster m2 = new Log(25, 20);
        Heart heart = new Heart(5,5);
        m1.setDirection(GameplayPresenter.ACTION.RIGHT);
        m2.setDirection(GameplayPresenter.ACTION.LEFT);
        dungeonPresenter.getModel().getMonsters().add(m1);
        dungeonPresenter.getModel().getMonsters().add(m2);
        dungeonPresenter.getModel().getHearts().add(heart);
        dungeonPresenter.checkMonsterCollisions(m1);
        assertEquals(GameplayPresenter.ACTION.LEFT, m1.getDirection());
        assertEquals(GameplayPresenter.ACTION.RIGHT, m2.getDirection());
        assertEquals(3.0f, m1.getHearts());
    }

}


