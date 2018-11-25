package agh.cs.tests;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab3.OptionsParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OptionsParserTest {

    @Test
    public void testParse() {

        String[] args = new String[4];
        args[0] = "forward";
        args[1] = "f";
        args[2] = "b";
        args[3] = "l";

        MoveDirection[] directions = new OptionsParser().parse(args);
        assertEquals(directions[0], MoveDirection.FORWARD);
        assertEquals(directions[1], MoveDirection.FORWARD);
        assertEquals(directions[2], MoveDirection.BACKWARD);
        assertEquals(directions[3], MoveDirection.LEFT);

    }
}