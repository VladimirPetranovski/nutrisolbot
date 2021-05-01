package com.avp.nutrisolbot.command;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    SETTINGS("/settings"),
    HELP("/help"),
//    UNKNOWN("/sfs"),
    NOCOMMAND("vglhi");

    private final String commandName;

    private CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }


}
