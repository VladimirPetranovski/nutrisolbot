package com.avp.nutrisolbot.command;

import static com.avp.nutrisolbot.command.CommandName.SETTINGS;
import static com.avp.nutrisolbot.command.SettingsCommand.SETTINGS_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

class SettingsCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return SETTINGS.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return SETTINGS_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new SettingsCommand(sendBotMessageService);
    }
}