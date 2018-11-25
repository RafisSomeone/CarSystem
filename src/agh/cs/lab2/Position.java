package agh.cs.lab2;

import java.util.Objects;

public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public String toString() {
        return "(" + this.x + "," + this.y + ")";

    }

    public boolean smaller(Position other) {
        if (this.x <= other.x && this.y <= other.y) return true;
        return false;


    }

    public boolean larger(Position other) {
        if (this.x >= other.x && this.y >= other.y) return true;
        return false;


    }

    public Position add(Position other) {
        int x = this.x + other.x;
        int y = this.y + other.y;
        Position nowy = new Position(x, y);
        return nowy;

    }

    public Position sub(Position other) {
        int x = this.x - other.x;
        int y = this.y - other.y;
        Position nowy = new Position(x, y);
        return nowy;

    }

    public Position upperRight(Position other) {
        int a, b;
        if (this.x >= other.x) a = this.x;
        else a = other.x;
        if (this.y >= other.y) b = this.y;
        else b = other.y;
        Position obiekt = new Position(a, b);
        return obiekt;
    }

    public Position loweLeft(Position other) {
        int a, b;
        if (this.x <= other.x) a = this.x;
        else a = other.x;
        if (this.y <= other.y) b = this.y;
        else b = other.y;
        Position obiekt = new Position(a, b);
        return obiekt;
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Position))
            return false;
        Position that = (Position) other;
        if (this.x == that.x && this.y == that.y) return true;

        return false;
    }
    @Override
    public int hashCode() {
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 17;
        return hash;
    }
}