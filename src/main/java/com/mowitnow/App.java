package com.mowitnow;

import com.mowitnow.service.MowingInstructionFileReader;
import com.mowitnow.service.MowingInstructionRunner;

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

    public static void handleFile(String filePath) throws Exception {
        new MowingInstructionRunner(new MowingInstructionFileReader(filePath)).run();
    }
}
