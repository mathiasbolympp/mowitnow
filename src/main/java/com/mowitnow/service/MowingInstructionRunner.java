package com.mowitnow.service;

import com.mowitnow.model.Lawn;
import com.mowitnow.model.Mower;
import com.mowitnow.model.MowingInstruction;

public class MowingInstructionRunner {
    private final MowingInstructionReader reader;

    public MowingInstructionRunner(MowingInstructionReader reader) {
        this.reader = reader;
    }

    public void run() throws Exception {
        MowingInstruction mowingInstruction;
        while((mowingInstruction=reader.getNextMowingInstruction()) != null) {
            handleInstruction(reader.getLawn(), mowingInstruction);
        }
    }

    public static void handleInstruction(Lawn lawn, MowingInstruction mowingInstruction) {
        Mower mower = mowingInstruction.getMower();
        mowingInstruction.getInstructions().forEach(command -> command.execute(lawn, mower));
        System.out.println(mower.toString());
    }
}
