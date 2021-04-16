package com.avp.nutrisolbot.service;

import com.avp.nutrisolbot.command.CommandContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.avp.nutrisolbot.command.CommandName.NO;

@Component
@PropertySource("application.properties")
public class NutrisolBot extends TelegramLongPollingBot {

    private static final String COMMAND_PREFIX = "/";

    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;

//    @Autowired
//    ObjectMapper objectMapper;
//    @Autowired
//    MessageService messageService;

    private final CommandContainer commandContainer;

    @Autowired
    public NutrisolBot() {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImp(this));
    }

    @Override
    public void onUpdateReceived(Update update) {
//        saveJson(update); // оставлю для тестов
//        SendMessage sendMessage = messageService.onUpdateReceived(update);
//        try {
//            execute(sendMessage);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

//    private void saveJson(Update update) {
//        try {
//            objectMapper.writeValue(new File("src/test/resources/update.json"), update);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
