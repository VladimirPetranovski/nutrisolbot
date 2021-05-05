package com.avp.nutrisolbot.student.handler;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    SETTINGS("/settings"),
    HELP("/help"),
    CONTACT("/sharedContact"),
    NOCOMMAND("vglhi");

    private final String commandName;

    private CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }


}
