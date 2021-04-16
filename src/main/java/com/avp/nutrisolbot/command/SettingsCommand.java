package com.avp.nutrisolbot.command;

import com.avp.nutrisolbot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SettingsCommand implements Command{

    private final static String SETTINGS_MESSAGE = "Here will be able anything)";

    private final SendBotMessageService sendBotMessageService;

    public SettingsCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), SETTINGS_MESSAGE);
    }
}
