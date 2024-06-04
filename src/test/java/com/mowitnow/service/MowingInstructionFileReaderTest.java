package com.mowitnow.service;

import com.mowitnow.command.Command;
import com.mowitnow.command.MoveForwardCommand;
import com.mowitnow.command.TurnLeftCommand;
import com.mowitnow.exception.InvalidFileFormatException;
import com.mowitnow.exception.InvalidOrientationException;
import com.mowitnow.model.Lawn;
import com.mowitnow.model.Mower;
import com.mowitnow.model.MowingInstruction;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MowingInstructionFileReaderTest {
    private final static String VALID_FILE_PATH = "src/test/resources/file.txt";

    private final static String SINGLE_MOWER_FILE_PATH = "src/test/resources/single_mower_file.txt";

    private final static String INVALID_FILE_PATH = "src/test/resources/invalid_file.txt";
    private static final String INVALID_FILE_EXPECTED_ERROR = "Invalid file format: Missing mower instructions";

    private final static String EMPTY_FILE_PATH = "src/test/resources/empty_file.txt";
    private static final String EMPTY_FILE_EXPECTED_ERROR = "Invalid file format: The file is empty";

    @Test
    public void shouldInitializeLawn() throws InvalidFileFormatException, IOException {
        MowingInstructionFileReader mowingInstructionFileReader = new MowingInstructionFileReader(VALID_FILE_PATH);
        mowingInstructionFileReader.close();

        Lawn lawn = mowingInstructionFileReader.getLawn();

        assertEquals(5, lawn.maxX());
        assertEquals(5, lawn.maxY());
    }

    @Test
    public void shouldThrowInvalidFileFormatExceptionOnEmptyFile() {
        InvalidFileFormatException exception = assertThrows(InvalidFileFormatException.class, () -> {
            new MowingInstructionFileReader(EMPTY_FILE_PATH);
        });

        assertEquals(EMPTY_FILE_EXPECTED_ERROR, exception.getMessage());
    }

    @Test
    public void shouldThrowInvalidFileFormatExceptionOnInvalidFile() {
        InvalidFileFormatException exception = assertThrows(InvalidFileFormatException.class, () -> {
            MowingInstructionFileReader mowingInstructionFileReader = new MowingInstructionFileReader(INVALID_FILE_PATH);
            mowingInstructionFileReader.getNextMowingInstruction();
            mowingInstructionFileReader.getNextMowingInstruction();
        });

        assertEquals(INVALID_FILE_EXPECTED_ERROR, exception.getMessage());
    }

    @Test
    public void shouldReadMowingInstructions() throws InvalidFileFormatException, IOException, InvalidOrientationException {
        MowingInstructionFileReader mowingInstructionFileReader = new MowingInstructionFileReader(SINGLE_MOWER_FILE_PATH);

        MowingInstruction mowingInstruction = mowingInstructionFileReader.getNextMowingInstruction();

        // The mower is at position (1, 2) and orientation N
        Mower mower = mowingInstruction.getMower();
        assertEquals(1, mower.getX());
        assertEquals(2, mower.getY());
        assertEquals("N", mower.getOrientation().toString());

        // The mower has 2 instructions: TurnLeft and MoveForward
        List<Command> instructions = mowingInstruction.getInstructions();
        assertEquals(2, instructions.size());
        assertInstanceOf(TurnLeftCommand.class, instructions.get(0));
        assertInstanceOf(MoveForwardCommand.class, instructions.get(1));

        // There is no more instruction
        assertNull(mowingInstructionFileReader.getNextMowingInstruction());
    }

}
