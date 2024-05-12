package it.unibs.arnaldo.tamagolem.main;

//TODO: metodi per visualizzare tutto

//TODO: DOC

//TODO: copia dal precedente + sistema

//TODO: public static String coloredMessage(String message, Color color)
//TODO: anche printColoredMessage da modificare


import it.kibo.fp.lib.AnsiColors;

public class UserInteraction {
    private static final int ERROR_SLEEP_TIME = 5000;
    private static final int CLEAR_SLEEP_TIME = 3000;

    public static void welcome() {
        //TODO: all.
    }

    public static int chooseDifficulty() {
        //TODO: all.
        return 0;
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

