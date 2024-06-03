package com.mowitnow.exception;

public class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException(String reason) {
        super("Invalid file format: " + reason);
    }
}
