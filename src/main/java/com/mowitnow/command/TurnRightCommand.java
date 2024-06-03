package com.mowitnow.command;

import com.mowitnow.model.ILawn;
import com.mowitnow.model.IMower;

import static com.mowitnow.model.Orientation.*;
import static com.mowitnow.model.Orientation.W;

public class TurnRightCommand implements Command {
    @Override
    public void execute(ILawn lawn, IMower mower) {
        mower.setOrientation(switch (mower.getOrientation()) {
            case W -> N;
            case N -> E;
            case E -> S;
            case S -> W;
        });
    }
}
