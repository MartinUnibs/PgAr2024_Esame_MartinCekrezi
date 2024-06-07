package it.unibs.arnaldo.bang.main;

import it.unibs.arnaldo.bang.game.GameManager;

public class BangMain {


    public static void main(String[] args) {
        UserInteraction.welcome();
        int nPlayer = UserInteraction.chooseNPlayers();

        GameManager gameManager = new GameManager(nPlayer);

    }

}
