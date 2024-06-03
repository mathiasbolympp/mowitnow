package com.mowitnow.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MowerTest {

    private Mower mower;

    @BeforeEach
    public void setUp() {
        mower = new Mower(1, 1, Orientation.N);
    }

    @Test
    public void testToString() {
        assertEquals("1 1 N", mower.toString());
    }

    @Test
    public void testGetX() {
        assertEquals(1, mower.getX());
    }

    @Test
    public void testSetX() {
        mower.setX(2);
        assertEquals(2, mower.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(1, mower.getY());
    }

    @Test
    public void testSetY() {
        mower.setY(2);
        assertEquals(2, mower.getY());
    }

    @Test
    public void testGetOrientation() {
        assertEquals(Orientation.N, mower.getOrientation());
    }

    @Test
    public void testSetOrientation() {
        mower.setOrientation(Orientation.E);
        assertEquals(Orientation.E, mower.getOrientation());
    }
}