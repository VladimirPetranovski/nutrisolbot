package com.avp.nutrisolbot.service;

import com.avp.nutrisolbot.bot.NutrisolBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendMessageServiceImp implements SendMessageService{

    private static final Logger log = LoggerFactory.getLogger(SendMessageServiceImp.class);

    private final NutrisolBot nutrisolBot;

    @Autowired
    public SendMessageServiceImp(NutrisolBot nutrisolBot) {
        this.nutrisolBot = nutrisolBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        try{
            nutrisolBot.execute(sendMessage);
        } catch (TelegramApiException e){
            log.info("The message didn't send");
            e.printStackTrace();
        }
    }
}
