package com.avp.nutrisolbot.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public interface SendMessageService {

    void sendMessage(String chatId, String message);

    void sendMessage(String chatId, String message, ReplyKeyboard replyKeyboard);

    void deleteMessage(String chatId, Integer message_id);
}
