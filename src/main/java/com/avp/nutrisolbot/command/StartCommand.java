package com.avp.nutrisolbot.command;

import com.avp.nutrisolbot.service.SendBotMessageService;
import com.avp.nutrisolbot.user.student.buttons.InlineButtonsStudent;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command{

    public final static String START_MESSAGE = "Здравствуйте, если вы решили заняться своим здоровьем или поддерживать свое тело в прекрасной форме - я помогу вам! Жми на кнопку ниже и присоединяйся";

    private final SendBotMessageService sendBotMessageService;
//    private final InlineButtonsStudent inlineButtonsStudent;

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
//        this.inlineButtonsStudent = inlineButtonsStudent;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
