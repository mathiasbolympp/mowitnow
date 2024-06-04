package com.mowitnow.service;

import com.mowitnow.model.Lawn;
import com.mowitnow.model.MowingInstruction;

public interface MowingInstructionReader {
    Lawn getLawn();

    MowingInstruction getNextMowingInstruction() throws Exception;
}
