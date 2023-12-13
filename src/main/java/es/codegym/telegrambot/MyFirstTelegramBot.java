package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.STEP_1_TEXT;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "CodeGymPasantia_bot";
    public static final String TOKEN = "6338216445:AAFKGuSds-FWc8bpC-Tp2fTF7TyLwHCgy4k";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        // Condicionales para responder en el programa
        if(getMessageText().equals("/start")){
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Hackear la nevera","step_1_btn"));
        }
        if(getMessageText().contains("hola") || getMessageText().contains("Hola")){
            sendTextMessageAsync("Hola, ¿Cuál es tu nombre?");
        }
        if(getMessageText().contains("me llamo") || getMessageText().contains("Me llamo") || getMessageText().contains("Mi nombre") || getMessageText().contains("mi nombre")){
            sendTextMessageAsync("Encantado de conocerte, soy *Gato*");
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}