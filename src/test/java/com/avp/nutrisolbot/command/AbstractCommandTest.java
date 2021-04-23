//package com.avp.nutrisolbot.command;
//
//import com.avp.nutrisolbot.service.NutrisolBot;
//import com.avp.nutrisolbot.service.SendBotMessageService;
//import com.avp.nutrisolbot.service.SendBotMessageServiceImp;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import org.telegram.telegrambots.meta.api.objects.Message;
//import org.telegram.telegrambots.meta.api.objects.Update;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//
//abstract class AbstractCommandTest {
//
//    protected NutrisolBot nutrisolBot = Mockito.mock(NutrisolBot.class);
//    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImp(nutrisolBot);
//
//    abstract String getCommandName();
//    abstract String getCommandMessage();
//    abstract Command getCommand();
//
//    @Test
//    public void execute() throws TelegramApiException {
//        Long chatId = 12345678L;
//
//        Update update = prepareUpdate(chatId, getCommandName());
//
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.setChatId(chatId.toString());
//        sendMessage.setText(getCommandMessage());
//        sendMessage.enableHtml(true);
//
//        getCommand().execute(update);
//        Mockito.verify(nutrisolBot).execute(sendMessage);
//    }
//
//    public static Update prepareUpdate(Long chatId, String commandName) {
//
//        Update update = new Update();
//        Message message = Mockito.mock(Message.class);
//        Mockito.when(message.getChatId()).thenReturn(chatId);
//        Mockito.when(message.getText()).thenReturn(commandName);
//        update.setMessage(message); // тут должен быть update,setMessage(message); // перепеши этот тест
//        return update;
//    }
//}
