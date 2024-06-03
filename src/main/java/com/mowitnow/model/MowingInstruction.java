package com.mowitnow.model;

import com.mowitnow.command.Command;

import java.util.List;

public class MowingInstruction implements IMowingInstruction {
    private final IMower mower;
    private final List<Command> instructions;

    public MowingInstruction(IMower mower, List<Command> instructions) {
        this.mower = mower;
        this.instructions = instructions;
    }

    public IMower getMower() {
        return mower;
    }

    public List<Command> getInstructions() {
        return instructions;
    }
}
