package agh.cs.tests;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {
    IWorldMap map1 = new RectangularMap(10, 10);

    @Test
    public void testToString() {
        Car honda = new Car(map1, 2, 2);
        assertEquals(honda.getPosition(), new Position(2, 2));

    }

    @Test
    public void testMove() {


        Car matiz = new Car(map1, 2, 2);
        map1.place(matiz);
        matiz.move(MoveDirection.FORWARD);
        assertEquals(matiz.getPosition(), new Position(2, 3));


    }
}