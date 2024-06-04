package com.mowitnow.command;

import com.mowitnow.model.Lawn;
import com.mowitnow.model.Mower;

import static com.mowitnow.model.Orientation.*;

public class TurnLeftCommand implements Command {
    @Override
    public void execute(Lawn lawn, Mower mower) {
        mower.setOrientation(switch (mower.getOrientation()) {
            case E -> N;
            case S -> E;
            case W -> S;
            case N -> W;
        });
    }
}
