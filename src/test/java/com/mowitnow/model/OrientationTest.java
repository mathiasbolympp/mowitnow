package com.mowitnow.model;

import com.mowitnow.exception.InvalidOrientationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrientationTest {

    @Test
    public void testFromStringValidOrientations() throws InvalidOrientationException {
        assertEquals(Orientation.N, Orientation.fromString("N"));
        assertEquals(Orientation.E, Orientation.fromString("E"));
        assertEquals(Orientation.S, Orientation.fromString("S"));
        assertEquals(Orientation.W, Orientation.fromString("W"));
    }

    @Test
    public void testFromStringInvalidOrientation() {
        assertThrows(InvalidOrientationException.class, () -> {
            Orientation.fromString("Invalid orientation");
        });
    }

    @Test
    public void testToString() {
        assertEquals("N", Orientation.N.toString());
        assertEquals("E", Orientation.E.toString());
        assertEquals("S", Orientation.S.toString());
        assertEquals("W", Orientation.W.toString());
    }
}
