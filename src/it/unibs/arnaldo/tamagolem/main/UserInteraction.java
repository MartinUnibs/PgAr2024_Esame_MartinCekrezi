package it.unibs.arnaldo.tamagolem.main;

import it.kibo.fp.lib.AnsiColors;
import it.kibo.fp.lib.InputData;

//TODO: metodi per visualizzare tutto

/*
 * This class manages every interaction with the user,
 * whether it's an input or an output. It follows this precise
 * color scheme: TODO: COLOR SCHEME
 * RED:
 * GREEN:
 * YELLOW:
 * CYAN:
 * PURPLE:
 * */
public class UserInteraction {
    private static final int ERROR_SLEEP_TIME = 5000;
    private static final int CLEAR_SLEEP_TIME = 3000;
    private static final String GAME_DIFFICULTY_MESSAGE = "Imposta la difficoltà della partita: ";
    private static final int MIN_DIFFICULTY = 3;
    private static final int MAX_DIFFICULTY = 10;
    private static final String PLAY_AGAIN_MESSAGE = "Vuoi fare un altro scontro? ";

    public static void welcome() {
        //TODO: all. + rules
    }

    public static int chooseDifficulty() {
        return InputData.readIntegerBetween(coloredMessage(GAME_DIFFICULTY_MESSAGE, AnsiColors.CYAN), MIN_DIFFICULTY, MAX_DIFFICULTY);
    }

    public static boolean playAgain() {
        return InputData.readYesOrNo(coloredMessage(PLAY_AGAIN_MESSAGE, AnsiColors.CYAN));
    }

    public static void farewell() {
        //TODO: all.
    }

    public static String coloredMessage(String message, AnsiColors color){
        return color + message + AnsiColors.RESET;
    }

    public static void printColoredMessage(String message, AnsiColors color) {
        System.out.println(coloredMessage(message, color));
    }

    public static void fatalError(String message) {
        printColoredMessage(message, AnsiColors.RED);
        try {
            Thread.sleep(ERROR_SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }

    public static void waitAndClear() {
        try {
            Thread.sleep(CLEAR_SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print(AnsiColors.CLEAR);
        System.out.flush();
    }

    public static void endingMessage() {
        //TODO: all.
    }

    public static void printGraph() {
        //TODO: all.
    }
}

