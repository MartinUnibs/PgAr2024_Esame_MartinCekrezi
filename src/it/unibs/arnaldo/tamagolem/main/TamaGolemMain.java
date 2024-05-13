package it.unibs.arnaldo.tamagolem.main;

import it.unibs.arnaldo.tamagolem.game.Duel;

//TODO: DOC
public class TamaGolemMain {

    public static void main(String[] args) {
        UserInteraction.welcome();
        boolean choice = true;
        do {
            int difficulty = UserInteraction.chooseDifficulty();
            Duel duel = new Duel(difficulty);
            duel.start();
            choice = false; //TODO: scelta utente se vuole continuare
        } while (choice);
        UserInteraction.farewell();
    }
}