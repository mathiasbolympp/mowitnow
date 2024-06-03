package com.mowitnow.model;

import com.mowitnow.exception.InvalidOrientationException;

public enum Orientation {
    N, E, S, W;

    public static Orientation fromString(String orientation) throws InvalidOrientationException {
        return switch (orientation) {
            case "N" -> N;
            case "E" -> E;
            case "S" -> S;
            case "W" -> W;
            default -> throw new InvalidOrientationException(orientation);
        };
    }

    @Override
    public String toString() {
        return name();
    }
}
