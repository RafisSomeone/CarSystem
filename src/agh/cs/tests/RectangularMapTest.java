package agh.cs.tests;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectangularMapTest {


    @Test
    public void testCanMoveTo() {
        IWorldMap map = new RectangularMap(6,9);

        assertTrue(map.canMoveTo(new Position(2, 4)));
        assertFalse(map.canMoveTo(new Position(14, 15)));
    }

    @Test
    public void testPlace() {
        IWorldMap map = new RectangularMap(6,9);
        Car auto = new Car(map);
        assertTrue(map.place(auto));


    }

    @Test
    public void testRun() {
        IWorldMap map = new RectangularMap(5,5); // USUNĄŁEM implements w rectangular map i unbounded map a IwordlMap wciąż działa ??
        Car auto = new Car(map);
        map.place(auto);
        MoveDirection[] route = new MoveDirection[4];
        route[0] = MoveDirection.FORWARD;
        route[1] = MoveDirection.LEFT;
        route[2] = MoveDirection.FORWARD;
        route[3] = MoveDirection.RIGHT;
        map.run(route);
        assertEquals(auto.getPosition(), new Position(1, 3));


    }

    @Test
    public void testIsOccupied() {
        IWorldMap map = new RectangularMap(5,5);
        Car auto = new Car( map);
        map.place(auto);
        assertTrue(map.isOccupied(new Position(2,2)));
        assertFalse(map.isOccupied(new Position(0, 0)));
    }


}