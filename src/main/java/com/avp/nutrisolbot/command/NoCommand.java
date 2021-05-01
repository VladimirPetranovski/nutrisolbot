package com.avp.nutrisolbot.command;

import com.avp.nutrisolbot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class NoCommand implements Command{

    private final SendMessageService sendMessageService;

    public static final String NO_COMMAND = "Я поддерживаю команды, начинающиеся со слеша(/). " +
            "Чтобы посмотреть список команд введите /help";

    public NoCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId(), NO_COMMAND);
    }
}
