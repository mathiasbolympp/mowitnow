package com.mowitnow.command;

import com.mowitnow.model.ILawn;
import com.mowitnow.model.IMower;

@FunctionalInterface
public interface Command {
    void execute(ILawn lawn, IMower mower);
}