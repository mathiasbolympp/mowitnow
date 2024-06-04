package com.mowitnow.service;

import com.mowitnow.command.CommandFactory;
import com.mowitnow.exception.InvalidFileFormatException;
import com.mowitnow.exception.InvalidOrientationException;
import com.mowitnow.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MowingInstructionFileReader implements MowingInstructionReader {
    private final Lawn lawn;
    private final BufferedReader reader;
    private static final String SPACE_SEPARATOR = " ";
    private static final String EMPTY_FILE_ERROR = "The file is empty";
    private static final String MISSING_INSTRUCTIONS_ERROR = "Missing mower instructions";

    public MowingInstructionFileReader(String filePath) throws InvalidFileFormatException, IOException {
        reader = new BufferedReader(new FileReader(filePath));

        // The first line is the lawn size
        String line = reader.readLine();
        if(line == null) {
            throw new InvalidFileFormatException(EMPTY_FILE_ERROR);
        }

        String[] lawnSize = line.split(SPACE_SEPARATOR);
        lawn = new Lawn(Integer.parseInt(lawnSize[0]), Integer.parseInt(lawnSize[1]));
    }

    public Lawn getLawn() {
        return lawn;
    }

    public MowingInstruction getNextMowingInstruction() throws IOException, InvalidFileFormatException, InvalidOrientationException {
        String line = reader.readLine();
        if(line == null) {
            reader.close();
            return null;
        }

        String[] mowerPosition = line.split(SPACE_SEPARATOR);
        Mower mower = new Mower(Integer.parseInt(mowerPosition[0]), Integer.parseInt(mowerPosition[1]), Orientation.fromString(mowerPosition[2]));

        line = reader.readLine();
        if(line == null) {
            throw new InvalidFileFormatException(MISSING_INSTRUCTIONS_ERROR);
        }

        return new MowingInstruction(
                mower,
                Arrays.stream(line.split(""))
                        .map(CommandFactory::fromString)
                        .collect(Collectors.toList())
        );
    }

    public void close() throws IOException {
        reader.close();
    }
}
