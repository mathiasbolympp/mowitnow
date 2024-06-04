package com.mowitnow.model;

import com.mowitnow.command.Command;

import java.util.List;

public class MowingInstruction {
    private final Mower mower;
    private final List<Command> instructions;

    public MowingInstruction(Mower mower, List<Command> instructions) {
        this.mower = mower;
        this.instructions = instructions;
    }

    public Mower getMower() {
        return mower;
    }

    public List<Command> getInstructions() {
        return instructions;
    }
}
