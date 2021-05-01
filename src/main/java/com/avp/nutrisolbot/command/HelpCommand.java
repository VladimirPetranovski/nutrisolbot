package com.avp.nutrisolbot.command;

import com.avp.nutrisolbot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.avp.nutrisolbot.command.CommandName.*;

public class HelpCommand implements Command{

    private final SendMessageService sendMessageService;

    public static final String HELP_MESSAGE = String.format("✨<b>Дотупные команды</b>✨\n\n"

                    + "<b>Начать\\закончить работу с ботом</b>\n"
                    + "%s - начать работу со мной\n"
                    + "%s - приостановить работу со мной\n\n"
                    + "%s - получить помощь в работе со мной\n"
                    + "%s - посмотреть настройки\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName(), SETTINGS.getCommandName());

    public HelpCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
