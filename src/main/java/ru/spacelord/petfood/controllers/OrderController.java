package ru.spacelord.petfood.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.spacelord.petfood.dto.OrderDTO;
import ru.spacelord.petfood.services.OrderService;

@CrossOrigin(origins = {"http://localhost:3000", "https://prosto-vkusno124.ru/"})
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/new-order")
    public void getOrder(@RequestBody OrderDTO orderDTO) throws TelegramApiException {
        orderService.sendOrder(orderDTO);
    }
}
