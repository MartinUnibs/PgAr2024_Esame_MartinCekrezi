package it.unibs.arnaldo.bang.main;

import it.kibo.fp.lib.AnsiColors;
import it.kibo.fp.lib.InputData;
import it.kibo.fp.lib.Menu;

import java.util.*;

//TODO: DOC
public class UserInteraction {
    private static final int TITLE_SLEEP_TIME = 500;
    private static final int INSTRUCTIONS_SLEEP_TIME = 500;
    private static final int ERROR_SLEEP_TIME = 5000;

    private static final String PLAY_AGAIN_MESSAGE = "Vuoi fare un altro scontro? ";
    private static final String SEPARATOR = ": ";
    private static final String PLAYER_WIN = "The *ruolo * won!!!\n\n";
    private final static String GETPLAYERNUMBER = "How many players are in this game? ( 4 to 7 ):";
    private final static int MIN_PLAYERS = 4;
    private final static int MAX_PLAYERS = 7;
    private static final String FAREWELL_MESSAGE = "Thanks for playing!";
    private static final String TITLE = "░█████╗░██████╗░███╗░░██╗░█████╗░██╗░░░░░██████╗░░█████╗░  ░██╗░░░░░░░██╗███████╗░██████╗████████╗\n" +
            "██╔══██╗██╔══██╗████╗░██║██╔══██╗██║░░░░░██╔══██╗██╔══██╗  ░██║░░██╗░░██║██╔════╝██╔════╝╚══██╔══╝\n" +
            "███████║██████╔╝██╔██╗██║███████║██║░░░░░██║░░██║██║░░██║  ░╚██╗████╗██╔╝█████╗░░╚█████╗░░░░██║░░░\n" +
            "██╔══██║██╔══██╗██║╚████║██╔══██║██║░░░░░██║░░██║██║░░██║  ░░████╔═████║░██╔══╝░░░╚═══██╗░░░██║░░░\n" +
            "██║░░██║██║░░██║██║░╚███║██║░░██║███████╗██████╔╝╚█████╔╝  ░░╚██╔╝░╚██╔╝░███████╗██████╔╝░░░██║░░░\n" +
            "╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚═╝╚══════╝╚═════╝░░╚════╝░  ░░░╚═╝░░░╚═╝░░╚══════╝╚═════╝░░░░╚═╝░░░";
    private static final String WELCOME_MESSAGE = "Welcome to Arnaldo West!";
    private static final String INSTRUCTIONS = "1. ";
    private static final String TABS = "\t\t";
    private static final String NUMBER_PRINTER = "%d\t\t";
    private static final String DOUBLE_ESCAPE_SEQUENCE = "\n\n";
    private static final String SINGLE_ESCAPE_SEQUENCE = "\n";
    private static final String ARROW = " -> ";




    public static void welcome() {
        System.out.println(TITLE);
        waitAndClear(TITLE_SLEEP_TIME);
        printColoredMessage(WELCOME_MESSAGE, AnsiColors.YELLOW);
        System.out.println(INSTRUCTIONS);
        try {
            Menu.wait(INSTRUCTIONS_SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int chooseNPlayers() {
        return InputData.readIntegerBetween(
                UserInteraction.coloredMessage(GETPLAYERNUMBER, AnsiColors.GREEN),
                MIN_PLAYERS, MAX_PLAYERS);
    }

    public static boolean playAgain() {
        return InputData.readYesOrNo(coloredMessage(PLAY_AGAIN_MESSAGE, AnsiColors.CYAN));
    }

    public static void farewell() {
        printColoredMessage(FAREWELL_MESSAGE, AnsiColors.YELLOW);
    }

    public static String coloredMessage(String message, AnsiColors color){
        return color + message + AnsiColors.RESET;
    }

    public static void printColoredMessage(String message, AnsiColors color) {
        System.out.println(coloredMessage(message, color));
    }

    public static void waitAndClear(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print(AnsiColors.CLEAR);
        System.out.flush();
    }

    public static void endingMessage(int winner) {
        printColoredMessage(PLAYER_WIN, AnsiColors.GREEN);
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
}

