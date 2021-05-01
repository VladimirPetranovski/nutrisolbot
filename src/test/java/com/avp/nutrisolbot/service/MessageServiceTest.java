package com.avp.nutrisolbot.service;

import com.avp.nutrisolbot.NutrisolBotApplicationTests;
import com.avp.nutrisolbot.bot.NutrisolBot;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageServiceTest extends NutrisolBotApplicationTests {

    @Autowired
    NutrisolBot nutrisolBot;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MessageService messageService;

    @Test
    void onStartReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/start.json"), Update.class);
        SendMessage actual = messageService.onUpdateReceived(update);
        SendMessage expected = makeMessage("Привет! А ты знаешь, что вода — это жизнь. Она участвует в процессах пищеварения и обмена веществ, " +
                "является одним из компонентов, необходимых для выработки крови, улучшает реологию желчи, участвует в " +
                "химических реакциях и в ферментативных процессах, помогает осуществлять процессы детоксикации организма. " +
                "Обезвоживание – главная причина усталости, низкой работоспособности, пониженной координации и судорог мышц. " +
                "Вода должна иметь уровень рН от 7,3 до 7,5 - очень похожий на  уровень рН крови, а также слабую минерализацию. " +
                "Обычный рекомендуемый объем потребления чистой воды в день для здорового человека - 2 литра. В зависимости от " +
                "заболеваний, возраста и образа жизни человека рекомендации меняются. " +
                "Необходимо проконсультироваться с вашим лечащим врачом. " +
                "Подробнее можно узнать по ссылке https://ru.wikipedia.org/wiki/%D0%93%D0%B8%D0%B4%D1%80%D0%BE%D0%B1%D0%B0%D0%BB%D0%B0%D0%BD%D1%81");
        assertEquals(expected, actual);
    }

    @Test
    void onUnknownReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/update.json"), Update.class);
        SendMessage actual = messageService.onUpdateReceived(update);
        SendMessage expected = makeMessage("Привет, пока у меня такой команды нет, я еще развиваюсь!)");
        assertEquals(expected, actual);
    }

    @Test
    void onHelpReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/help.json"), Update.class);
        SendMessage actual = messageService.onUpdateReceived(update);
        SendMessage expected = makeMessage("Help");
        assertEquals(expected, actual);
    }

    @Test
    void onSettingsReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/settings.json"), Update.class);
        SendMessage actual = messageService.onUpdateReceived(update);
        SendMessage expected = makeMessage("Settings");
        assertEquals(expected, actual);
    }

    private SendMessage makeMessage(String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(1083113433L);
        sendMessage.setText(text);
        return sendMessage;
    }
}