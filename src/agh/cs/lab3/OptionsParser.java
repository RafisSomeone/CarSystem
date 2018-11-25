package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;


public class OptionsParser {


    public MoveDirection[] parse(String[] args) {
        MoveDirection[] directions = new MoveDirection[args.length];
        int index = 0;
        for (String a : args) {
            if (a.equals("f") || a.equals("forward")) directions[index] = MoveDirection.FORWARD;
            else if (a.equals("b") || a.equals("backward")) directions[index] = MoveDirection.BACKWARD;
            else if (a.equals("l") || a.equals("left")) directions[index] = MoveDirection.LEFT;
            else if (a.equals("r") || a.equals("right")) directions[index] = MoveDirection.RIGHT;
            else throw new IllegalArgumentException((a + " is not legal move specification"));
            index++;
        }

        return directions;


    }


}
