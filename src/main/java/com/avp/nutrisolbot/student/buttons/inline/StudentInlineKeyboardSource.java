package com.avp.nutrisolbot.student.buttons.inline;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class StudentInlineKeyboardSource {

    public InlineKeyboardMarkup getStartAndShareContact() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton firstKeyboard = new InlineKeyboardButton();
        firstKeyboard.setText("SHARE CONTACT");
        firstKeyboard.setCallbackData("/sharedContact");

        List<InlineKeyboardButton> keyboardFirstRow = new ArrayList<>();
        keyboardFirstRow.add(firstKeyboard);

        List<List<InlineKeyboardButton>> keyboardsRows = new ArrayList<>();
        keyboardsRows.add(keyboardFirstRow);

        inlineKeyboardMarkup.setKeyboard(keyboardsRows);

        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup getKeyboardAfterShareContact() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton firstButton = new InlineKeyboardButton();
        firstButton.setText("Вода");
        firstButton.setCallbackData("/choseWater");

        InlineKeyboardButton secondButton = new InlineKeyboardButton();
        secondButton.setText("Здоровое питание");
        secondButton.setCallbackData("/choseFood");

        InlineKeyboardButton thirdButton = new InlineKeyboardButton();
        thirdButton.setText("Психотерапия");
        thirdButton.setCallbackData("/chosePsychotherapy");

        InlineKeyboardButton fourthButton = new InlineKeyboardButton();
        fourthButton.setText("Шагомер");
        fourthButton.setCallbackData("/chosePedometer");

        List<InlineKeyboardButton> firstKeyboardRow = new ArrayList<>();
        firstKeyboardRow.add(firstButton);
        firstKeyboardRow.add(secondButton);

        List<InlineKeyboardButton> secondKeyboardRow = new ArrayList<>();
        secondKeyboardRow.add(thirdButton);
        secondKeyboardRow.add(fourthButton);

        List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();
        keyboardRows.add(firstKeyboardRow);
        keyboardRows.add(secondKeyboardRow);

        inlineKeyboardMarkup.setKeyboard(keyboardRows);

        return inlineKeyboardMarkup;
    }
}
