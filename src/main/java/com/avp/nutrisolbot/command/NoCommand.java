package com.avp.nutrisolbot.command;

import com.avp.nutrisolbot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class NoCommand implements Command{

    private static final String NO_MESSAGE = "Я поддерживаю команды, начинающиеся со слеша(/).\n " +
            "Чтобы посмотреть список команд введите /help";

    private final SendBotMessageService sendBotMessageService;

    public NoCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
