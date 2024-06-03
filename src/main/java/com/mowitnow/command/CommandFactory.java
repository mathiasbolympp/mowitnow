package com.mowitnow.command;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final Map<String, Command> commandMap = new HashMap<>();

    static {
        commandMap.put("A", new MoveForwardCommand());
        commandMap.put("D", new TurnRightCommand());
        commandMap.put("G", new TurnLeftCommand());
    }

    public static Command fromString(String commandName) {
        return commandMap.get(commandName);
    }
}
