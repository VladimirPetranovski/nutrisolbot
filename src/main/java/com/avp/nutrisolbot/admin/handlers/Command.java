package com.avp.nutrisolbot.admin.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {

    void execute(Update update);
}
