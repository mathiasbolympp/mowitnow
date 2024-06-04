package com.mowitnow.command;

import com.mowitnow.model.Lawn;
import com.mowitnow.model.Mower;

public interface Command {
    void execute(Lawn lawn, Mower mower);
}