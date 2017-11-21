package by.tc.controller;

import by.tc.controller.exception.InternalServerException;
import by.tc.controller.impl.DisplayCommand;
import by.tc.controller.impl.ParseCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private static final Map<ControllerCommand, XMLCommand> commands = new HashMap<>();

    static {
        commands.put(ControllerCommand.PARSE, new ParseCommand());
        commands.put(ControllerCommand.DISPLAY, new DisplayCommand());
    }

    public static XMLCommand getCommand(String name) throws InternalServerException {
        XMLCommand command;

        try {
            command = commands.get(ControllerCommand.valueOf(name));
        } catch (Exception e) {
            throw new InternalServerException(e);
        }

        return command;
    }
}
