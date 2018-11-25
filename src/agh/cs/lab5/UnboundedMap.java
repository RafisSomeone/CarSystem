package agh.cs.lab5;

import agh.cs.lab2.Position;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {
    private List<HayStack> heys;


    public UnboundedMap(ArrayList hey) {

        heys = hey;

    }


    @Override
    public Object objectAt(Position position) {

        Object object = super.objectAt(position);
        if (object != null) return object;

        for (HayStack hay : heys) {
            if (hay.getPosition().equals(position)) return hay;

        }
        return null;
    }

    /* @Override
    *public String toString() {
         return super.toString(new Position(-10,-10), new Position(10,10));
     }*/
    public String toString() {

        return new MapVisualizer(this).draw(new Position(-10, -10), new Position(10, 10));
    }
}
