package com.avp.nutrisolbot.command;

import com.avp.nutrisolbot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SettingsCommand implements Command{

    private final SendMessageService sendMessageService;

    private static final String SETTINGS_MESSAGE = "Тут будут какие то настройки";

    public SettingsCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId(), SETTINGS_MESSAGE);
    }
}
