package ru.spacelord.petfood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.spacelord.petfood.dto.OrderDTO;
import ru.spacelord.petfood.dto.ProductInBucketDTO;
import ru.spacelord.petfood.model.TelegramBot;


@Service
public class OrderService {

    @Value("${telegrambot.ownerId}")
    private Long ownerId;
    private final TelegramBot telegramBot;

    @Autowired
    public OrderService(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void sendOrder(OrderDTO orderDTO) throws TelegramApiException {
        StringBuilder products = new StringBuilder();
        for(ProductInBucketDTO product: orderDTO.getProducts()) {
            products.append(product.getTitle()).append(", ").append(product.getSize()).append(" грамм,").append("цена ").append(product.getPrice()).append(" рублей \n");
        }
        String text = "Привет, Настя! Пришел заказ на общую сумму "
                + orderDTO.getFullPrice()
                + "." + "Контакты данного человека: \n"
                + "Имя: " + orderDTO.getContacts().getName() + "\n"
                + "Номер телефона: " + orderDTO.getContacts().getPhone() + "\n"
                + "Предпочитаемая связь: " + orderDTO.getContacts().getCommunicationPlace().toString() + "\n"
                + "Заказанные продукты и их вес: \n" + products;

        telegramBot.execute(SendMessage.builder()
                        .chatId(ownerId)
                        .text(text)
                .build());
    }
}
