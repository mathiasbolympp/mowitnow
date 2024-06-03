package com.mowitnow;

import com.mowitnow.command.CommandFactory;
import com.mowitnow.exception.InvalidFileFormatException;
import com.mowitnow.exception.InvalidOrientationException;
import com.mowitnow.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args ) {
        if(args.length == 0) {
            System.out.println("Please provide a file path as argument");
            return;
        }

        try {
            handleFile(args[0]);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void handleFile(String filePath) throws IOException, InvalidFileFormatException, InvalidOrientationException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        // The first line is the lawn size
        String line = reader.readLine();
        if(line == null) {
            throw new InvalidFileFormatException("The file is empty");
        }

        String[] lawnSize = line.split(" ");
        ILawn lawn = new Lawn(Integer.parseInt(lawnSize[0]), Integer.parseInt(lawnSize[1]));

        for (IMowingInstruction mowingInstruction = getNextMowingInstructions(reader); mowingInstruction != null; mowingInstruction = getNextMowingInstructions(reader)) {
            handleInstruction(lawn, mowingInstruction);
        }
    }

    public static IMowingInstruction getNextMowingInstructions(BufferedReader reader) throws InvalidOrientationException, IOException, InvalidFileFormatException {
        String line = reader.readLine();
        if(line == null) {
            return null;
        }

        String[] mowerPosition = line.split(" ");
        IMower mower = new Mower(Integer.parseInt(mowerPosition[0]), Integer.parseInt(mowerPosition[1]), Orientation.fromString(mowerPosition[2]));

        line = reader.readLine();
        if(line == null) {
            throw new InvalidFileFormatException("Missing mower instructions");
        }

        return new MowingInstruction(
                mower,
                Arrays.stream(line.split(""))
                        .map(CommandFactory::fromString)
                        .collect(Collectors.toList())
        );
    }

    public static void handleInstruction(ILawn lawn, IMowingInstruction mowingInstruction) {
        IMower mower = mowingInstruction.getMower();
        mowingInstruction.getInstructions().forEach(command -> command.execute(lawn, mower));
        System.out.println(mower.toString());
    }
}
