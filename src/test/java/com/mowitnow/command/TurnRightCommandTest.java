package com.mowitnow.command;

import com.mowitnow.model.Lawn;
import com.mowitnow.model.Mower;
import com.mowitnow.model.Orientation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TurnRightCommandTest {

    private final Lawn lawn = new Lawn(5, 5);

    private final TurnRightCommand turnRightCommand = new TurnRightCommand();

    @Test
    public void shouldTurnToWest() {
        Mower mower = new Mower(1, 1, Orientation.S);

        turnRightCommand.execute(lawn, mower);

        assertEquals(1, mower.getX());
        assertEquals(1, mower.getY());
        assertEquals(Orientation.W, mower.getOrientation());
    }

    @Test
    public void shouldTurnToSouth() {
        Mower mower = new Mower(1, 1, Orientation.E);

        turnRightCommand.execute(lawn, mower);

        assertEquals(1, mower.getX());
        assertEquals(1, mower.getY());
        assertEquals(Orientation.S, mower.getOrientation());
    }

    @Test
    public void shouldTurnToEast() {
        Mower mower = new Mower(1, 1, Orientation.N);

        turnRightCommand.execute(lawn, mower);

        assertEquals(1, mower.getX());
        assertEquals(1, mower.getY());
        assertEquals(Orientation.E, mower.getOrientation());
    }

    @Test
    public void shouldTurnToNorth() {

        Mower mower = new Mower(1, 1, Orientation.W);

        turnRightCommand.execute(lawn, mower);

        assertEquals(1, mower.getX());
        assertEquals(1, mower.getY());
        assertEquals(Orientation.N, mower.getOrientation());
    }

}
