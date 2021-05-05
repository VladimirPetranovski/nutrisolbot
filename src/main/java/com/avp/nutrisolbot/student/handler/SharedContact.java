package com.avp.nutrisolbot.student.handler;

import com.avp.nutrisolbot.service.SendMessageService;
import com.avp.nutrisolbot.student.buttons.inline.StudentInlineKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class SharedContact implements Command{

    private final StudentInlineKeyboardSource studentInlineKeyboardSource = new StudentInlineKeyboardSource();
    private final SendMessageService sendMessageService;
    private static final String ADDED_CONTACT = "Я очень рад, что ты решил с нами заниматься, я уверяю тебя ты не пожалеешь об этом \\ud83d\\ude09 !" +
            "Выбери один из пунктов, кот тебе больше всего нравится, нажав на одну из кнопок ниже.";
    private final ReplyKeyboard ADDED_CONTACT_BUTTONS = studentInlineKeyboardSource.getKeyboardAfterShareContact();

    public SharedContact(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
//        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
//
//        Integer message_id = update.getCallbackQuery().getMessage().getMessageId();
//
//        sendMessageService.deleteMessage(chatId, message_id);

        sendMessageService.sendMessage(update.getCallbackQuery().getMessage().getChatId().toString(), ADDED_CONTACT, ADDED_CONTACT_BUTTONS);
    }
}
