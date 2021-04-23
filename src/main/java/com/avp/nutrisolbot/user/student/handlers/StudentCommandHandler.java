package com.avp.nutrisolbot.user.student.handlers;

import com.avp.nutrisolbot.user.student.states.StudentBotContext;
import com.avp.nutrisolbot.user.student.states.StudentBotState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class StudentCommandHandler {

    private static final Logger log = LoggerFactory.getLogger(StudentCommandHandler.class);

    public static boolean FLAG = false;

    public void handler(Update update) throws TelegramApiException {
        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                studentInputMessage(update);
            }
        }
    }

    private void studentInputMessage(Update update) {
        final Long chatId = update.getMessage().getChatId();

        StudentBotContext botContext = null;
        StudentBotState botState = null;
    }
}
