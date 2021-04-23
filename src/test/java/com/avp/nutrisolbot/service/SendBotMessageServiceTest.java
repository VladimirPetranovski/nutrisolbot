package com.avp.nutrisolbot.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private NutrisolBot nutrisolBotTest;

    @BeforeEach
    public void beforeEach() {
        nutrisolBotTest = Mockito.mock(NutrisolBot.class);
        sendBotMessageService = new SendBotMessageServiceImp(nutrisolBotTest);
    }

    @Test
    void sendMessage() throws TelegramApiException {
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message).enableHtml(true);

        sendBotMessageService.sendMessage(chatId, message);
        Mockito.verify(nutrisolBotTest).execute(sendMessage);
    }
}