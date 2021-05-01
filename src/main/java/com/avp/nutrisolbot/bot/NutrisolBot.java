package com.avp.nutrisolbot.bot;

import com.avp.nutrisolbot.command.CommandContainer;
import com.avp.nutrisolbot.service.SendMessageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.avp.nutrisolbot.command.CommandName.NOCOMMAND;

@Component
@PropertySource("application.properties")
public class NutrisolBot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;

    private final CommandContainer commandContainer;

    @Autowired
    public NutrisolBot() {
        commandContainer = new CommandContainer(new SendMessageServiceImp(this));
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith("/")) {
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

}
