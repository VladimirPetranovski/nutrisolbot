package com.avp.nutrisolbot.student.handler;

import com.avp.nutrisolbot.service.SendMessageService;
import com.avp.nutrisolbot.student.buttons.inline.StudentInlineKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class StartCommand implements Command {

    private final StudentInlineKeyboardSource studentInlineKeyboardSource = new StudentInlineKeyboardSource();

    private final SendMessageService sendMessageService;

    public static final String START_MESSAGE = "Привет-привет! Я рад приветствовать тебя, меня зовут NutrisolBot." +
            "В нынешней экологической обстановке и неблагоприятном психологическом фоне, неплохо было бы поддерживать " +
            "организм в хорошей форме, поэтому если ты решил заняться своим здоровьем, я тебе понравлюсь. " +
            "Жми на кнопку ниже --- будем знакомиться!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";

    private final ReplyKeyboard SHARE_CONTACT = studentInlineKeyboardSource.getStartAndShareContact();

    public StartCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE, SHARE_CONTACT);
    }
}
