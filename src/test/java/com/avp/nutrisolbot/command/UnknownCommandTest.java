package com.avp.nutrisolbot.command;

import static com.avp.nutrisolbot.command.UnknownCommand.UNKNOWN_MESSAGE;

class UnknownCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return "/kjlfndfnl";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}