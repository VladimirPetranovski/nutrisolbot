package com.avp.nutrisolbot.command;

import com.avp.nutrisolbot.service.SendMessageService;
import com.google.common.collect.ImmutableMap;

import static com.avp.nutrisolbot.command.CommandName.*;

public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    public final Command unknownCommand;

    public CommandContainer(SendMessageService sendMessageService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendMessageService))
                .put(NOCOMMAND.getCommandName(), new NoCommand(sendMessageService))
                .build();
        unknownCommand = new UnknownCommand(sendMessageService);
    }

    public Command retrieveCommand (String identifier) {
        return commandMap.getOrDefault(identifier, unknownCommand);
    }
}
