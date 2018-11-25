package agh.cs.lab4;

import agh.cs.lab2.Position;
import agh.cs.lab5.AbstractWorldMap;

public class RectangularMap extends AbstractWorldMap {
    private int width;
    private int height;
    private final Position upperConstraint;
    private final Position lowerConstraint = new Position(0, 0);


    public RectangularMap() {
        this.height = 10;
        this.width = 10;
        this.upperConstraint = new Position(width, height);
    }

    public RectangularMap(int width, int height) {
        this.height = height;
        this.width = width;
        this.upperConstraint = new Position(width, height);
    }


    @Override
    public boolean canMoveTo(Position position) {
        if (position.smaller(upperConstraint) && position.larger(lowerConstraint) && super.canMoveTo(position))
            return true;
        return false;
    }

    /*   @Override
       public String toString() {

           return super.toString(upperConstraint, lowerConstraint);
       }*/
    public String toString() {

        return new MapVisualizer(this).draw(lowerConstraint, upperConstraint);
    }
}
