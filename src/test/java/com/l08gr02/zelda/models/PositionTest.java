package com.l08gr02.zelda.models;

import com.l08gr02.zelda.models.elements.Position;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

/* ADAPTADO DE UM EXEMPLO DO PROF ANDRÉ RESTIVO */
class PositionTest {
    @Property
    void getLeft(@ForAll int x, @ForAll int y, @ForAll int i) {
        assertEquals(x - i, new Position(x, y).left(i).getX());
        assertEquals(y, new Position(x, y).left(i).getY());
    }

    @Property
    void getRight(@ForAll int x, @ForAll int y, @ForAll int i) {
        assertEquals(x + i, new Position(x, y).right(i).getX());
        assertEquals(y, new Position(x, y).right(i).getY());
    }

    @Property
    void getUp(@ForAll int x, @ForAll int y, @ForAll int i) {
        assertEquals(x, new Position(x, y).up(i).getX());
        assertEquals(y - i, new Position(x, y).up(i).getY());
    }

    @Property
    void getDown(@ForAll int x, @ForAll int y, @ForAll int i) {
        assertEquals(x, new Position(x, y).down(i).getX());
        assertEquals(y + i, new Position(x, y).down(i).getY());
    }
}
