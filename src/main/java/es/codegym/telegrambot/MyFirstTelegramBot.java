package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "CodeGymPasantia_bot";
    public static final String TOKEN = "6338216445:AAFKGuSds-FWc8bpC-Tp2fTF7TyLwHCgy4k";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        // Mensajes para saludar
        if(getMessageText().contains("hola") || getMessageText().contains("Hola")){
            sendTextMessageAsync("Hola, ¿Cuál es tu nombre?");
        }
        if(getMessageText().contains("me llamo") || getMessageText().contains("Me llamo") || getMessageText().contains("Mi nombre") || getMessageText().contains("mi nombre")){
            sendTextMessageAsync("Encantado de conocerte, soy *Gato*");
        }

        // Condicionales para responder en el programa
        if(getMessageText().equals("/start")){
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Hackear la nevera","step_1_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT, Map.of("¡Tomar una salchicha! +20 de fama","step_2_btn",
                                                "¡Tomar un pescado! +20 de fama","step_2_btn",
                                                "¡Tirar una lata de pepinillos! +20 de fama","step_2_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_2_btn")){
            sendTextMessageAsync(STEP_3_TEXT, Map.of("Hackear al robot aspiradora","step_3_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_3_btn")){
            addUserGlory(30);
            sendTextMessageAsync(STEP_4_TEXT, Map.of("¡Enviar al robot aspirador a por comida! +30 de fama","step_4_btn",
                    "¡Dar un paseo en el robot aspirardor! +30 de fama","step_4_btn",
                    "¡Huir del robot aspirador! +30 de fama","step_4_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_4_btn")){
            sendTextMessageAsync(STEP_5_TEXT, Map.of("Ponerse la GoPro", "step_5_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_5_btn")){
            addUserGlory(40);
            sendTextMessageAsync(STEP_6_TEXT, Map.of("¡Juguete de ratón! +30 de fama","step_6_btn",
                    "¡Un nuevo atuendo para el frio! +30 de fama","step_6_btn",
                    "¡Regalo secreto navideño! +30 de fama","step_6_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_6_btn")){
            sendTextMessageAsync(STEP_7_TEXT, Map.of("Hackear la contraseña del PC", "step_7_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_7_btn")){
            addUserGlory(50);
            sendTextMessageAsync(STEP_8_TEXT, Map.of("Eres un crack! ¿Acaso hay algo que no sepas hacer?","step_8_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_8_btn")){
            sendTextMessageAsync(FINAL_TEXT, Map.of("Convertirse en el jefe de la mafia de los gatos","step_9_btn"));
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}