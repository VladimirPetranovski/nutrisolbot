package com.avp.nutrisolbot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageServiceImp implements SendBotMessageService{

    private static final Logger log = LoggerFactory.getLogger(SendBotMessageServiceImp.class);

//    @Autowired
//    NutrisolBot nutrisolBot;
    private final NutrisolBot nutrisolBot;
    @Autowired
    public SendBotMessageServiceImp(NutrisolBot nutrisolBot) {
        this.nutrisolBot = nutrisolBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            nutrisolBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.info("Сообщение не принято");
            e.printStackTrace();
        }
    }
}
