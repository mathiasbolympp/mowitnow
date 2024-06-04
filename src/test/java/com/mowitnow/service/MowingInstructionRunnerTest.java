package com.mowitnow.service;

import com.mowitnow.command.Command;
import com.mowitnow.command.MoveForwardCommand;
import com.mowitnow.command.TurnRightCommand;
import com.mowitnow.model.Lawn;
import com.mowitnow.model.Mower;
import com.mowitnow.model.MowingInstruction;
import com.mowitnow.model.Orientation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MowingInstructionRunnerTest {
    @Mock
    private MowingInstructionReader reader;

    @Mock
    private Command turnRightCommand;

    @Mock
    private Command moveForwardCommand;

    @InjectMocks
    private MowingInstructionRunner runner;

    @Test
    public void shouldRun() throws Exception {

        MowingInstruction mowingInstruction1 = new MowingInstruction(
                new Mower(1,1, Orientation.S),
                List.of(new Command[]{turnRightCommand, moveForwardCommand})
        );

        MowingInstruction mowingInstruction2 = new MowingInstruction(
                new Mower(2,3, Orientation.E),
                List.of(new Command[]{moveForwardCommand})
        );

        when(reader.getNextMowingInstruction())
                .thenReturn(mowingInstruction1)
                .thenReturn(mowingInstruction2)
                .thenReturn(null);

        runner.run();

        verify(reader, times(3)).getNextMowingInstruction();
    }

    @Test
    public void shouldHandleInstruction() throws Exception {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 1, Orientation.N);

        MowingInstruction mowingInstruction = new MowingInstruction(
                mower,
                List.of(new Command[]{moveForwardCommand, moveForwardCommand})
        );

        MowingInstructionRunner.handleInstruction(lawn, mowingInstruction);

        verify(moveForwardCommand, times(2)).execute(lawn, mower);
    }

}
