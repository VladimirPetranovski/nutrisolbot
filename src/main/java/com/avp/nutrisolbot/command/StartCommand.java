package com.avp.nutrisolbot.command;

import com.avp.nutrisolbot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command{

    private final SendMessageService sendMessageService;

    public static final String START_MESSAGE = "Привет! А ты знаешь, что вода — это жизнь. " +
            "Она участвует в процессах пищеварения и обмена веществ, является одним из компонентов, " +
            "необходимых для выработки крови, улучшает реологию желчи, участвует в химических реакциях " +
            "и в ферментативных процессах, помогает осуществлять процессы детоксикации организма. " +
            "Обезвоживание – главная причина усталости, низкой работоспособности, пониженной координации " +
            "и судорог мышц. Вода должна иметь уровень рН от 7,3 до 7,5 - очень похожий на  уровень рН крови, " +
            "а также слабую минерализацию. " +
            "Обычный рекомендуемый объем потребления чистой воды в день для здорового человека - 2 литра. " +
            "В зависимости от заболеваний, возраста и образа жизни человека рекомендации меняются. " +
            "Необходимо проконсультироваться с вашим лечащим врачом. Подробнее можно узнать по ссылке " +
            "https://ru.wikipedia.org/wiki/%D0%93%D0%B8%D0%B4%D1%80%D0%BE%D0%B1%D0%B0%D0%BB%D0%B0%D0%BD%D1%81.";

    public StartCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId(), START_MESSAGE);
    }
}
