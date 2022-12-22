package com.l08gr02.zelda.models;

import com.l08gr02.zelda.models.elements.Hitbox;
import com.l08gr02.zelda.models.elements.moving.Link;
import com.l08gr02.zelda.models.elements.moving.monsters.Log;
import com.l08gr02.zelda.models.elements.moving.monsters.Weirdo;
import com.l08gr02.zelda.presenters.GameplayPresenter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FighterTest {
    @Test
    void LinkTest(){

        Link link = new Link(10,10); //Link is a Fighter

        //Testing constructor
        assertEquals(link.getHearts(), 3.0);
        assertEquals(link.getDirection(), GameplayPresenter.ACTION.DOWN);

        //Testing speed
        link.walk();
        assertEquals(link.getSpeed(), 2);
        link.sprint();
        assertEquals(link.getSpeed(), 4);

        //Testing attack
        //DOWN
        link.attack();
        assertEquals(link.getAttackHitbox(), new Hitbox(10, 10 + 36, 44, 8));

        //LEFT
        link.setDirection(GameplayPresenter.ACTION.LEFT);
        link.attack();
        assertEquals(link.getAttackHitbox(),new Hitbox(10, 10, 8, 44));

        //RIGHT
        link.setDirection(GameplayPresenter.ACTION.RIGHT);
        link.attack();
        assertEquals(link.getAttackHitbox(), new Hitbox(10 + 36, 10, 8, 44));

        //UP
        link.setDirection(GameplayPresenter.ACTION.UP);
        link.attack();
        assertEquals(link.getAttackHitbox(), new Hitbox(10 + 4, 10 + 4, 38, 8));

        //Testing health (we have already seen that he has 3 hearts)
        link.takeDamage((float) 0.75);
        assertEquals(link.getHearts(),2.25);
        link.heal((float) 0.75);
        assertEquals(link.getHearts(),3.0);
        link.setHearts((float) 1234.5);
        assertEquals(link.getHearts(),1234.5);

    }

    @Test
    void LogTest(){
        //Testing constructor
        Log log = new Log(10,10);
        assertEquals(log.getHearts(),2);
        assertEquals(log.getSpeed(), 3);
        assertEquals(log.getHitbox(), new Hitbox(10 + 8, 10 + 12, 16, 16));

        //Just testing constructor seeing as though anything else that can be tested has already been tested on LinkTest
    }

    @Test
    void WeirdoTest(){
        //Testing constructor
        Weirdo weirdo = new Weirdo(10,10);
        assertEquals(weirdo.getHearts(),3.0);
        assertEquals(weirdo.getSpeed(),2);
        assertEquals(weirdo.getHitbox(),new Hitbox(10 + 8, 10 + 12, 16, 16));

        //Just testing constructor seeing as though anything else that can be tested has already been tested on LinkTest
    }
}
