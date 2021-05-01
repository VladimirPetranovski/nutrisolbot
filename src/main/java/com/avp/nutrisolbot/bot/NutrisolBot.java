package com.avp.nutrisolbot.bot;

import com.avp.nutrisolbot.command.CommandContainer;
import com.avp.nutrisolbot.command.NoCommand;
import com.avp.nutrisolbot.service.SendMessageServiceImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Locale;

import static com.avp.nutrisolbot.command.CommandName.NOCOMMAND;

@Component
@PropertySource("application.properties")
public class NutrisolBot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;

//    @Autowired
//    ObjectMapper objectMapper;
//    @Autowired
//    MessageService messageService;

    private static String COMMAND_PREFIX = "/";

    private final CommandContainer commandContainer;

    public NutrisolBot() {
        commandContainer = new CommandContainer(new SendMessageServiceImp(this));
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String identifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(identifier).execute(update);
            }else {
                commandContainer.retrieveCommand(NOCOMMAND.getCommandName()).execute(update);
            }

        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

//    @Override
//    public void onUpdateReceived(Update update) {
////        saveJson(update); // оставлю для тестов
////        SendMessage sendMessage = messageService.onUpdateReceived(update);
////        try {
////            execute(sendMessage);
////        } catch (TelegramApiException e) {
////            e.printStackTrace();
////        }
//    }

    //    private void saveJson(Update update) {
//        try {
//            objectMapper.writeValue(new File("src/test/resources/update.json"), update);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
