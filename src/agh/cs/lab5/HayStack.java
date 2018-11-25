package agh.cs.lab5;

import agh.cs.lab2.Position;

public class HayStack {

    private Position position;

    public HayStack(Position coordinates) {
        position = coordinates;
    }


    public Position getPosition() {
        return this.position;
    }

    public String toString() {
        return "S";

    }
}

