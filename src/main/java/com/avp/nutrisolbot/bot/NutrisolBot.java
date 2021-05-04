package com.avp.nutrisolbot.bot;

import com.avp.nutrisolbot.admin.handlers.AdminCommandHandler;
import com.avp.nutrisolbot.bean.User;
import com.avp.nutrisolbot.service.SendMessageServiceImp;
import com.avp.nutrisolbot.student.handler.StudentCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@PropertySource("application.properties")
public class NutrisolBot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;

//    private final CommandContainer commandContainer;
    private final AdminCommandHandler adminCommandHandler;
    private final StudentCommandHandler studentCommandHandler;

    @Autowired
    public NutrisolBot() {

//        commandContainer = new CommandContainer(new SendMessageServiceImp(this));
        adminCommandHandler = new AdminCommandHandler(new SendMessageServiceImp(this));
        studentCommandHandler = new StudentCommandHandler(new SendMessageServiceImp(this));
    }

    @Override
    public void onUpdateReceived(Update update) {

//        Long userId = getUserId(update);

        User user = new User(); // тут будет в дальнейшем получение пользователя из БД

        studentCommandHandler.handle(update);

//        if (user != null) {
//            checkRoleAndHandlerCall(user, update);
//        } else {
////            userRegistration(userId, update);
//        }
//        if (update.hasMessage() && update.getMessage().hasText()) {
//            String message = update.getMessage().getText().trim();
//            if (message.startsWith("/")) {
//                String identifier = message.split(" ")[0].toLowerCase();
//                commandContainer.retrieveCommand(identifier).execute(update);
//            }else {
//                commandContainer.retrieveCommand(NOCOMMAND.getCommandName()).execute(update);
//            }
//
//        }
    }

    private Long getUserId(Update update) {

        if (update.hasMessage()) {
            return update.getMessage().getFrom().getId().longValue();
        } else if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getFrom().getId().longValue();
        } else if (update.hasEditedMessage()) {
            return update.getEditedMessage().getFrom().getId().longValue();
        }
        return null;
    }

    private void checkRoleAndHandlerCall(User user, Update update) {

//        Long userId = getUserId(update);
        switch (user.getRole()) {
            case ADMIN:
                adminCommandHandler.handle(update);
                break;
            case STUDENT:
                studentCommandHandler.handle(update);
                break;
            default:
                break;
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
