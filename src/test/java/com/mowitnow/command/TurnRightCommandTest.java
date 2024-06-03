package com.mowitnow.command;

import com.mowitnow.model.ILawn;
import com.mowitnow.model.IMower;
import com.mowitnow.model.Orientation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TurnRightCommandTest {

    @Mock
    private ILawn lawn;

    @Mock
    private IMower mower;

    @InjectMocks
    private TurnRightCommand turnRightCommand;

    @Test
    public void shouldTurnToWest() {
        initializeMower(Orientation.S);

        turnRightCommand.execute(lawn, mower);

        verify(mower, times(1)).setOrientation(Orientation.W);
        verify(mower, never()).setX(anyInt());
        verify(mower, never()).setY(anyInt());
    }

    @Test
    public void shouldTurnToSouth() {
        initializeMower(Orientation.E);

        turnRightCommand.execute(lawn, mower);

        verify(mower, times(1)).setOrientation(Orientation.S);
        verify(mower, never()).setX(anyInt());
        verify(mower, never()).setY(anyInt());
    }

    @Test
    public void shouldTurnToEast() {
        initializeMower(Orientation.N);

        turnRightCommand.execute(lawn, mower);

        verify(mower, times(1)).setOrientation(Orientation.E);
        verify(mower, never()).setX(anyInt());
        verify(mower, never()).setY(anyInt());
    }

    @Test
    public void shouldTurnToNorth() {
        initializeMower(Orientation.W);

        turnRightCommand.execute(lawn, mower);

        verify(mower, times(1)).setOrientation(Orientation.N);
        verify(mower, never()).setX(anyInt());
        verify(mower, never()).setY(anyInt());
    }

    private void initializeMower(Orientation orientation){
        when(mower.getOrientation()).thenReturn(orientation);
    }
}
