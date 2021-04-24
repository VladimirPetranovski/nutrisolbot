package com.avp.nutrisolbot.user.student.handlers;

import com.avp.nutrisolbot.model.Student;
import com.avp.nutrisolbot.model.User;
import com.avp.nutrisolbot.service.UserService;
import com.avp.nutrisolbot.user.student.states.StudentBotContext;
import com.avp.nutrisolbot.user.student.states.StudentBotState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class StudentCommandHandler {

    @Autowired
    UserService userService;

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

        User user = userService.findByChatId(chatId);
        Student student = user.getStudent();
    }
}
