package com.avp.nutrisolbot.student.handler;

import com.avp.nutrisolbot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command {

    private final SendMessageService sendMessageService;

    public static final String STOP_MESSAGE = "Деактивировал все ваши подписки \uD83D\uDE1F.";

    public StopCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
