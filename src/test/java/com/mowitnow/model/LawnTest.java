package com.mowitnow.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LawnTest {

    private Lawn lawn;

    @BeforeEach
    public void setUp() {
        lawn = new Lawn(3, 4);
    }

    @Test
    public void testMaxX() {
        assertEquals(3, lawn.maxX());
    }

    @Test
    public void testMaxY() {
        assertEquals(4, lawn.maxY());
    }
}