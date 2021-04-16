package com.avp.nutrisolbot.command;

public enum CommandName {
    START("/start"),
    HELP("/help"),
    SETTINGS("/settings"),
    NO("nocommand");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
