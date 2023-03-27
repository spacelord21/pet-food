package ru.spacelord.petfood.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import ru.spacelord.petfood.model.TelegramFacade;
import ru.spacelord.petfood.model.TelegramBot;


@Configuration
public class AppConfig {
    private final TelegramBotConfig telegramBotConfig;

    public AppConfig(TelegramBotConfig telegramBotConfig) {
        this.telegramBotConfig = telegramBotConfig;
    }

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(telegramBotConfig.getWebHookPath()).build();
    }

    @Bean
    public TelegramBot springWebhookBot(SetWebhook setWebhook, TelegramFacade telegramFacade) {
        TelegramBot bot = new TelegramBot(setWebhook,telegramFacade);
        bot.setBotPath(telegramBotConfig.getWebHookPath());
        bot.setBotToken(telegramBotConfig.getBotToken());
        bot.setBotUsername(telegramBotConfig.getUserName());
        return bot;
    }
}
