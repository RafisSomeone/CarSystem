package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab7.IPositionChangeObserver;

import java.util.LinkedList;
import java.util.List;

public class Car {
    private MapDirection orientacja;
    private Position pozycja;
    private IWorldMap map;

    private List<IPositionChangeObserver> carObserver = new LinkedList<>();
    private final static Position y = new Position(0, 1);
    private final static Position x = new Position(1, 0);

    public Car(Position pozycja, MapDirection orientacja) {
        this.pozycja = pozycja;
        this.orientacja = orientacja;
    }

    public Car(IWorldMap map) {
        this.map = map;
        this.pozycja = new Position(2, 2);
        this.orientacja = MapDirection.NORTH;
    }

    public Car(IWorldMap map, int x, int y) {
        this.map = map;
        this.pozycja = new Position(x, y);
        this.orientacja = MapDirection.NORTH;
    }

    public Position getPosition() {
        return this.pozycja;

    }


    public String toString() {

        switch (this.orientacja) {

            case NORTH:
                return "^";
            case SOUTH:
                return "v";
            case WEST:
                return "<";
            case EAST:
                return ">";
            default:
                return null;


        }


    }

    public void move(MoveDirection direction) {

        int Δ = 10;

        Position oldPosition = this.pozycja;
        Position tmp = this.pozycja;

        switch (direction) {
            case RIGHT:
                this.orientacja = this.orientacja.next();
                break;
            case LEFT:
                this.orientacja = this.orientacja.previous();
                break;
            case BACKWARD:
                switch (this.orientacja) {
                    case NORTH:
                        tmp = this.pozycja.sub(y);
                        break;
                    case SOUTH:
                        tmp = this.pozycja.add(y);
                        break;
                    case EAST:
                        tmp = this.pozycja.sub(x);
                        break;
                    case WEST:
                        tmp = this.pozycja.add(x);
                        break;

                }

                break;
            case FORWARD:
                switch (this.orientacja) {
                    case NORTH:
                        tmp = this.pozycja.add(y);
                        break;
                    case SOUTH:
                        tmp = this.pozycja.sub(y);
                        break;
                    case EAST:
                        tmp = this.pozycja.add(x);
                        break;
                    case WEST:
                        tmp = this.pozycja.sub(x);
                        break;

                }

                break;


        }
        if (map.canMoveTo(tmp) || oldPosition.equals(tmp)) {
            this.pozycja = tmp;
        }

    }

    public void addObserver(IPositionChangeObserver observer) {
        carObserver.add(observer);

    }

    public void removeObserver(IPositionChangeObserver observer) {
        carObserver.remove(observer);
    }

    public boolean positionChanged() {

        return true;C:\Users\rafal\IdeaProjects\Projekt1
    }
}
