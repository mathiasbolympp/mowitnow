package com.mowitnow.model;

import com.mowitnow.command.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MowingInstructionTest {

    @Mock
    private IMower mower;

    @Mock
    private Command command1;

    @Mock
    private Command command2;

    private List<Command> instructions;
    private MowingInstruction mowingInstruction;

    @BeforeEach
    public void setUp() {
        instructions = List.of(command1, command2);
        mowingInstruction = new MowingInstruction(mower, instructions);
    }

    @Test
    public void testGetMower() {
        assertEquals(mower, mowingInstruction.getMower());
    }

    @Test
    public void testGetInstructions() {
        assertEquals(instructions, mowingInstruction.getInstructions());
    }
}