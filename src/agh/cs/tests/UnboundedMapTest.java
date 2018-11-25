package agh.cs.tests;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.HayStack;
import agh.cs.lab5.UnboundedMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UnboundedMapTest {

    @Test
    public void testCanMoveTo() {
        List<HayStack> hays = new ArrayList<>();
        IWorldMap map = new UnboundedMap((ArrayList) hays);
        assertTrue(!map.isOccupied(new Position(3, 4)));
        hays.add(new HayStack(new Position(5, 5)));
        assertTrue(map.isOccupied(new Position(5, 5)));

    }

    @Test
    public void testPlace() {
        List<HayStack> hays1 = new ArrayList<>();
        IWorldMap map1 = new UnboundedMap((ArrayList) hays1);
        Car auto = new Car(map1, 5, 5);
        assertTrue(map1.place(auto));
        hays1.add(new HayStack(new Position(3, 3)));


    }

    @Test
    public void testRun() {
        MoveDirection[] directions = new MoveDirection[4];
        directions[0] = MoveDirection.FORWARD;
        directions[1] = MoveDirection.LEFT;
        directions[2] = MoveDirection.LEFT;
        directions[3] = MoveDirection.BACKWARD;
        List<HayStack> hays2 = new ArrayList<>();
        IWorldMap map2 = new UnboundedMap((ArrayList) hays2);
        Car auto = new Car(map2, 3, 3);
        map2.place(auto);
        map2.run(directions);
        assertEquals(new Position(3, 5), auto.getPosition());
        Car matiz = new Car(map2);
        map2.place(matiz);
        map2.run(directions);
        assertEquals(new Position(3, 4), auto.getPosition());
        assertEquals(new Position(3, 2), matiz.getPosition());

    }

    @Test
    public void testIsOccupied() {
        List<HayStack> hays = new ArrayList<>();
        IWorldMap map = new UnboundedMap((ArrayList) hays);
        assertFalse(map.isOccupied(new Position(1, 2)));
        hays.add(new HayStack(new Position(1, 2)));
        assertTrue(map.isOccupied(new Position(1, 2)));
        assertFalse(map.isOccupied(new Position(4, 4)));
        Car auto = new Car(map, 4, 4);
        map.place(auto);
        assertTrue(map.isOccupied(new Position(4, 4)));


    }

    @Test
    public void objectAt() {
        List<HayStack> hays = new ArrayList<>();
        IWorldMap map = new UnboundedMap((ArrayList) hays);
        hays.add(new HayStack(new Position(4, 4)));
        assertTrue(map.objectAt(new Position(4, 4)) instanceof HayStack);
        Car punto = new Car(map);
        map.place(punto);
        assertTrue(map.objectAt(new Position(2, 2)) instanceof Car);
        assertNull(map.objectAt(new Position(1, 1)));
    }


}