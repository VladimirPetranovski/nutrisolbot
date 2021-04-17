package com.avp.nutrisolbot.command;

import static com.avp.nutrisolbot.command.CommandName.START;
import static com.avp.nutrisolbot.command.StartCommand.START_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

class StartCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}