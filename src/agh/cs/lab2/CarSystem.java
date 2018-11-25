package agh.cs.lab2;

import agh.cs.lab3.Car;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.HayStack;
import agh.cs.lab5.UnboundedMap;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarSystem {


    public static void main(String[] args) {



        try {


            MoveDirection[] directions = new OptionsParser().parse(args);
            List<HayStack> hays = new ArrayList<>();
            hays.add(new HayStack(new Position(-4, -4)));
            hays.add(new HayStack(new Position(7, 7)));
            hays.add(new HayStack(new Position(3, 6)));
            hays.add(new HayStack(new Position(2, 0)));
            IWorldMap map = new UnboundedMap((ArrayList) hays);
            map.place(new Car(map,3,3));
            map.place(new Car(map, 3, 4));
            map.run(directions);

            System.out.println(map.toString());

        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }


    }

}





