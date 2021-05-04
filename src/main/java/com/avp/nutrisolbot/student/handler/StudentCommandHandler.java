package com.avp.nutrisolbot.student.handler;

import com.avp.nutrisolbot.service.SendMessageService;
import com.google.common.collect.ImmutableMap;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.avp.nutrisolbot.command.CommandName.*;

public class StudentCommandHandler {

    private final ImmutableMap<String, Command> commandMap;
    public final Command unknownCommand;

    public StudentCommandHandler(SendMessageService sendMessageService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendMessageService))
                .put(SETTINGS.getCommandName(), new SettingsCommand(sendMessageService))
                .put(NOCOMMAND.getCommandName(), new NoCommand(sendMessageService))
                .build();
        unknownCommand = new UnknownCommand(sendMessageService);
    }

    public void handle(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith("/")) {
                String identifier = message.split(" ")[0].toLowerCase();
                retrieveCommand(identifier).execute(update);
            }else {
                retrieveCommand(NOCOMMAND.getCommandName()).execute(update);
            }
        }
    }

    private Command retrieveCommand (String identifier) {
        return commandMap.getOrDefault(identifier, unknownCommand);
    }
}
