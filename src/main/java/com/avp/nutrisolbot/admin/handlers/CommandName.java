package com.avp.nutrisolbot.admin.handlers;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    SETTINGS("/settings"),
    HELP("/help"),
    NOCOMMAND("vglhi");

    private final String commandName;

    private CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }


}
