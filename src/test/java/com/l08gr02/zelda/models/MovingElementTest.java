package com.l08gr02.zelda.models;

import com.l08gr02.zelda.models.elements.moving.Link;
import com.l08gr02.zelda.models.elements.moving.MovingElement;
import com.l08gr02.zelda.models.elements.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovingElementTest {
    private int x, y;
    private Position pos;
    private static Random rng = new Random();
    private MovingElement mover;

    @BeforeEach
    void init(){
        x = rng.nextInt(); y = rng.nextInt();

        pos = new Position(x, y);
    }

    @Test
    void LinkTest() {
        mover = new Link(x, y);

        // CIMA
        int i = rng.nextInt();

        y -= i;
        mover.up(i);

        assertEquals(pos.up(i), mover.getPosition());
        assertEquals(y, mover.getPosition().getY());

        pos = pos.up(i);

        // BAIXO
        i = rng.nextInt();

        y += i;
        mover.down(i);

        assertEquals(pos.down(i), mover.getPosition());
        assertEquals(y, mover.getPosition().getY());

        pos = pos.down(i);

        // ESQUERDA
        i = rng.nextInt();

        x -= i;
        mover.left(i);

        assertEquals(pos.left(i), mover.getPosition());
        assertEquals(x, mover.getPosition().getX());

        pos = pos.left(i);

        // DIREITA
        i = rng.nextInt();

        x += i;
        mover.right(i);

        assertEquals(pos.right(i), mover.getPosition());
        assertEquals(x, mover.getPosition().getX());
    }

}
