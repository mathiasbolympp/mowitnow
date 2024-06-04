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

    private final static String VALID_FILE_PATH = "src/test/resources/file.txt";
    private final static String VALID_FILE_EXPECTED_OUTPUT = "1 3 N\n5 1 E\n";

    private final static String INVALID_FILE_PATH = "src/test/resources/invalid_file.txt";
    private final static String INVALID_FILE_EXPECTED_OUTPUT = "1 3 N\nAn error occurred: Invalid file format: Missing mower instructions\n";

    private final static String EMPTY_FILE_PATH = "src/test/resources/empty_file.txt";
    private final static String EMPTY_FILE_EXPECTED_OUTPUT = "An error occurred: Invalid file format: The file is empty\n";

    private final static String NO_FILE_PROVIDED_EXPECTED_OUTPUT = "Please provide a file path as argument\n";

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
        String[] args = {new File(VALID_FILE_PATH).getAbsolutePath()};
        App.main(args);

        assertEquals(normalizeLineEndings(VALID_FILE_EXPECTED_OUTPUT), normalizeLineEndings(outContent.toString()));
    }

    @Test
    public void shouldErrorOnInvalidFileFormat()
    {
        String[] args = {new File(INVALID_FILE_PATH).getAbsolutePath()};
        App.main(args);

        assertEquals(normalizeLineEndings(INVALID_FILE_EXPECTED_OUTPUT), normalizeLineEndings(outContent.toString()));
    }

    @Test
    public void shouldErrorOnEmptyFile()
    {
        String[] args = {new File(EMPTY_FILE_PATH).getAbsolutePath()};
        App.main(args);

        assertEquals(normalizeLineEndings(EMPTY_FILE_EXPECTED_OUTPUT), normalizeLineEndings(outContent.toString()));
    }

    @Test
    public void shouldErrorWhenNoArgs()
    {
        String[] args = {};
        App.main(args);

        assertEquals(normalizeLineEndings(NO_FILE_PROVIDED_EXPECTED_OUTPUT), normalizeLineEndings(outContent.toString()));
    }

    private String normalizeLineEndings(String s) {
        return s.replace("\r\n", "\n")
                .replace("\r", "\n");
    }

    @AfterEach()
    public void cleanUp() {
        System.setOut(originalOutstream);
    }
}
