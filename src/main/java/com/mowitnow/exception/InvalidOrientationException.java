package com.mowitnow.exception;

public class InvalidOrientationException extends Exception {
    public InvalidOrientationException(String orientation) {
        super("Invalid orientation: " + orientation);
    }
}
