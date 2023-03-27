package ru.spacelord.petfood.model;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramFacade {


    public BotApiMethod<?> handleUpdate(Update update) {
        if(update.hasCallbackQuery()) {
            return null;
//            return handleInputCallbackData(update);
        }
        else {
            Message message = update.getMessage();
            if(message.hasText()) {
//                return handleInputMessage(message);
                return SendMessage.builder()
                        .chatId(661696935L)
                        .text("тут")
                        .build();
            }
        }
        return null;
    }
}
