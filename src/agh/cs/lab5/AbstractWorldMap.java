package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab7.IPositionChangeObserver;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected Map<Position, Car> cars = new LinkedHashMap<>();


    public boolean canMoveTo(Position position) {

        if (!isOccupied(position)) return true;
        return false;
    }

    public boolean place(Car car) throws IllegalArgumentException {
        if (!isOccupied(car.getPosition())) {
            cars.put(car.getPosition(), car);
            return true;
        } else throw new IllegalArgumentException("Position " + car.getPosition().toString() + " is already taken ");

    }

    public void run(MoveDirection[] directions) {

        List<Car> listOfCars = new LinkedList(cars.values());

        for (int i = 0; i < directions.length; i++) {
            Car auto = listOfCars.get(i % listOfCars.size());
            Position firstPosition = auto.getPosition();

            auto.move(directions[i]);
            if (!auto.getPosition().equals(firstPosition)) {
                cars.remove(firstPosition);
                cars.put(auto.getPosition(), auto);
            }


        }


    }

    public boolean isOccupied(Position position) {
        if (objectAt(position) instanceof Car || objectAt(position) instanceof HayStack) return true;
        return false;
    }

    public Object objectAt(Position position) {
        return cars.get(position);
    }
/*
   public String toString(Position upperConstraint, Position lowerConstraint) {

        return new MapVisualizer(this).draw(lowerConstraint, upperConstraint);
    }*/

    @Override
    public void positionChanged(Position oldPosition, Position newPosition) {
        Car auto = cars.get(oldPosition);
        cars.remove(oldPosition);
        cars.put(newPosition, auto);
    }
}
