package com.mowitnow.command;

import com.mowitnow.model.Lawn;
import com.mowitnow.model.Mower;

import static com.mowitnow.model.Orientation.*;
import static com.mowitnow.model.Orientation.W;

public class TurnRightCommand implements Command {
    @Override
    public void execute(Lawn lawn, Mower mower) {
        mower.setOrientation(switch (mower.getOrientation()) {
            case W -> N;
            case N -> E;
            case E -> S;
            case S -> W;
        });
    }
}
