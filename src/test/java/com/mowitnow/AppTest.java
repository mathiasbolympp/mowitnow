package com.mowitnow;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;


public class AppTest 
{
    private ByteArrayOutputStream outContent;
    private PrintStream originalOutstream;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOutstream = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldShowRightPosition()
    {
        String[] args = {new File("src/test/resources/file.txt").getAbsolutePath()};
        App.main(args);

        String expectedOutput = "1 3 N\n5 1 E\n";
        assertEquals(normalizeLineEndings(expectedOutput), normalizeLineEndings(outContent.toString()));
    }

    @Test
    public void shouldErrorOnInvalidFileFormat()
    {
        String[] args = {new File("src/test/resources/invalid_file.txt").getAbsolutePath()};
        App.main(args);

        String expectedOutput = "1 3 N\nAn error occurred: Invalid file format: Missing mower instructions\n";
        assertEquals(normalizeLineEndings(expectedOutput), normalizeLineEndings(outContent.toString()));
    }

    @Test
    public void shouldErrorOnEmptyFileFormat()
    {
        String[] args = {new File("src/test/resources/empty_file.txt").getAbsolutePath()};
        App.main(args);

        String expectedOutput = "An error occurred: Invalid file format: The file is empty\n";
        assertEquals(normalizeLineEndings(expectedOutput), normalizeLineEndings(outContent.toString()));
    }

    @Test
    public void shouldErrorWhenNoArgs()
    {
        String[] args = {};
        App.main(args);

        String expectedOutput = "Please provide a file path as argument\n";
        assertEquals(normalizeLineEndings(expectedOutput), normalizeLineEndings(outContent.toString()));
    }

    private String normalizeLineEndings(String s) {
        return s.replace("\r\n", "\n").replace("\r", "\n");
    }

    @AfterEach()
    public void cleanUp() {
        System.setOut(originalOutstream);
    }
}
