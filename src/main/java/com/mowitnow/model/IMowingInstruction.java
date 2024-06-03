package com.mowitnow.model;

import com.mowitnow.command.Command;

import java.util.List;

public interface IMowingInstruction {
    IMower getMower();

    List<Command> getInstructions();
}
