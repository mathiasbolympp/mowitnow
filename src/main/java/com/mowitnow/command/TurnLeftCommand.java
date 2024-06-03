package com.mowitnow.command;

import com.mowitnow.model.ILawn;
import com.mowitnow.model.IMower;

import static com.mowitnow.model.Orientation.*;

public class TurnLeftCommand implements Command {
    @Override
    public void execute(ILawn lawn, IMower mower) {
        mower.setOrientation(switch (mower.getOrientation()) {
            case E -> N;
            case S -> E;
            case W -> S;
            case N -> W;
        });
    }
}
