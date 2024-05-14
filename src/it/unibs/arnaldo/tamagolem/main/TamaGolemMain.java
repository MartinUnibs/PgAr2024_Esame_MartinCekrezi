package it.unibs.arnaldo.tamagolem.main;

import it.unibs.arnaldo.tamagolem.game.Duel;

/*
 * Main class of the program, it starts a loop in which
 * a duel is managed until the user(s) decide to quit.
 * */
public class TamaGolemMain {

    public static void main(String[] args) {
        UserInteraction.welcome();
        boolean choice = true;
        do {
            int difficulty = UserInteraction.chooseDifficulty();
            Duel duel = new Duel(difficulty);
            duel.start();
            choice = UserInteraction.playAgain();
        } while (choice);
        UserInteraction.farewell();
    }
}