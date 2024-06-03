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
public class MoveForwardCommandTest
{
    @Mock
    private ILawn lawn;

    @Mock
    private IMower mower;

    @InjectMocks
    private MoveForwardCommand moveForwardCommand;

    @Test
    public void shouldMoveForwardNorth()
    {
        when(lawn.maxY()).thenReturn(5);
        initializeMower(1, 1, Orientation.N);

        moveForwardCommand.execute(lawn, mower);

        verify(mower, times(1)).setY(2);
        verify(mower, never()).setX(anyInt());
    }

    @Test
    public void shouldMoveForwardEast()
    {
        when(lawn.maxX()).thenReturn(5);
        initializeMower(1, 1, Orientation.E);

        moveForwardCommand.execute(lawn, mower);

        verify(mower, times(1)).setX(2);
        verify(mower, never()).setY(anyInt());
        verify(mower, never()).setOrientation(any(Orientation.class));
    }

    @Test
    public void shouldMoveForwardSouth()
    {
        initializeMower(1, 1, Orientation.S);

        moveForwardCommand.execute(lawn, mower);

        verify(mower, times(1)).setY(0);
        verify(mower, never()).setX(anyInt());
        verify(mower, never()).setOrientation(any(Orientation.class));
    }

    @Test
    public void shouldMoveForwardWest()
    {
        initializeMower(1, 1, Orientation.W);

        moveForwardCommand.execute(lawn, mower);

        verify(mower, times(1)).setX(0);
        verify(mower, never()).setY(anyInt());
        verify(mower, never()).setOrientation(any(Orientation.class));
    }

    @Test
    public void shouldNotMoveForwardNorth()
    {
        when(lawn.maxY()).thenReturn(5);
        initializeMower(1, 5, Orientation.N);

        moveForwardCommand.execute(lawn, mower);

        verify(mower, times(1)).setY(5);
        verify(mower, never()).setX(anyInt());
        verify(mower, never()).setOrientation(any(Orientation.class));
    }

    @Test
    public void shouldNotMoveForwardEast()
    {
        when(lawn.maxX()).thenReturn(5);
        initializeMower(5, 1, Orientation.E);

        moveForwardCommand.execute(lawn, mower);

        verify(mower, times(1)).setX(5);
        verify(mower, never()).setY(anyInt());
        verify(mower, never()).setOrientation(any(Orientation.class));
    }

    @Test
    public void shouldNotMoveForwardSouth()
    {
        initializeMower(1, 0, Orientation.S);

        moveForwardCommand.execute(lawn, mower);

        verify(mower, times(1)).setY(0);
        verify(mower, never()).setX(anyInt());
        verify(mower, never()).setOrientation(any(Orientation.class));
    }

    @Test
    public void shouldNotMoveForwardWest()
    {
        initializeMower(0, 1, Orientation.W);

        moveForwardCommand.execute(lawn, mower);

        verify(mower, times(1)).setX(0);
        verify(mower, never()).setY(anyInt());
        verify(mower, never()).setOrientation(any(Orientation.class));
    }

    private void initializeMower(int x, int y, Orientation orientation){
        when(mower.getX()).thenReturn(x);
        when(mower.getY()).thenReturn(y);
        when(mower.getOrientation()).thenReturn(orientation);
    }
}
