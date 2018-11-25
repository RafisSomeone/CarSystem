package agh.cs.tests;

import agh.cs.lab2.Position;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PositionTest {

    @Test
    public void testToString() {
        assertEquals("(1,2)", new Position(1, 2).toString());
    }

    @org.junit.Test
    public void testSmaller() {
        assertTrue(new Position(1, 2).smaller(new Position(3, 4)));
    }

    @org.junit.Test
    public void testLarger() {
        assertTrue(new Position(1, 2).larger(new Position(0, 1)));
    }

    @org.junit.Test
    public void add() {
        assertEquals(new Position(1, 2), new Position(0, 0).add(new Position(1, 2)));//jak on porównuje przez equals mój czy obiektowy
    }

    @org.junit.Test
    public void testUpperRight() {
        assertEquals(new Position(2, 2), new Position(1, 2).upperRight(new Position(2, 1)));
    }

    @org.junit.Test
    public void testLoweLeft() {
        assertEquals(new Position(1, 1), new Position(1, 2).loweLeft(new Position(2, 1)));
    }
}