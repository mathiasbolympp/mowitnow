package com.mowitnow.command;

import com.mowitnow.model.Lawn;
import com.mowitnow.model.Mower;
import com.mowitnow.model.Orientation;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class MoveForwardCommandTest
{
    private final MoveForwardCommand moveForwardCommand = new MoveForwardCommand();

    @Test
    public void shouldMoveForwardNorth()
    {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 1, Orientation.N);

        moveForwardCommand.execute(lawn, mower);

        assertEquals(1, mower.getX());
        assertEquals(2, mower.getY());
        assertEquals(Orientation.N, mower.getOrientation());
    }

    @Test
    public void shouldMoveForwardEast()
    {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 1, Orientation.E);

        moveForwardCommand.execute(lawn, mower);

        assertEquals(2, mower.getX());
        assertEquals(1, mower.getY());
        assertEquals(Orientation.E, mower.getOrientation());
    }

    @Test
    public void shouldMoveForwardSouth()
    {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 1, Orientation.S);

        moveForwardCommand.execute(lawn, mower);

        assertEquals(1, mower.getX());
        assertEquals(0, mower.getY());
        assertEquals(Orientation.S, mower.getOrientation());
    }

    @Test
    public void shouldMoveForwardWest()
    {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 1, Orientation.W);

        moveForwardCommand.execute(lawn, mower);

        assertEquals(0, mower.getX());
        assertEquals(1, mower.getY());
        assertEquals(Orientation.W, mower.getOrientation());
    }

    @Test
    public void shouldNotMoveForwardNorth()
    {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 5, Orientation.N);

        moveForwardCommand.execute(lawn, mower);

        assertEquals(1, mower.getX());
        assertEquals(5, mower.getY());
        assertEquals(Orientation.N, mower.getOrientation());
    }

    @Test
    public void shouldNotMoveForwardEast()
    {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(5, 1, Orientation.E);

        moveForwardCommand.execute(lawn, mower);

        assertEquals(5, mower.getX());
        assertEquals(1, mower.getY());
        assertEquals(Orientation.E, mower.getOrientation());
    }

    @Test
    public void shouldNotMoveForwardSouth()
    {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 0, Orientation.S);

        moveForwardCommand.execute(lawn, mower);

        assertEquals(1, mower.getX());
        assertEquals(0, mower.getY());
        assertEquals(Orientation.S, mower.getOrientation());
    }

    @Test
    public void shouldNotMoveForwardWest()
    {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(0, 1, Orientation.W);

        moveForwardCommand.execute(lawn, mower);

        assertEquals(0, mower.getX());
        assertEquals(1, mower.getY());
        assertEquals(Orientation.W, mower.getOrientation());
    }
}
