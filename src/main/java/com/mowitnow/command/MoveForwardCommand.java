package com.mowitnow.command;

import com.mowitnow.model.Lawn;
import com.mowitnow.model.Mower;

public class MoveForwardCommand implements Command {
    @Override
    public void execute(Lawn lawn, Mower mower) {
        int x = mower.getX();
        int y = mower.getY();

        switch (mower.getOrientation()) {
            case N -> mower.setY(Math.min(y + 1, lawn.maxY()));
            case E -> mower.setX(Math.min(x + 1, lawn.maxX()));
            case S -> mower.setY(Math.max(y - 1, 0));
            case W -> mower.setX(Math.max(x - 1, 0));
        }
    }
}