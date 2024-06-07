package it.unibs.arnaldo.bang.main;

import it.kibo.fp.lib.InputData;
import it.unibs.arnaldo.bang.game.GameManager;
import it.unibs.arnaldo.bang.io.InputManager;
import it.unibs.arnaldo.bang.moduloextra.Taunt;
public class BangMain {


    private static final String TAUNT_TXT = "Would you like to taunt?";

    public static void main(String[] args) {
        UserInteraction.welcome();
        int nPlayer = UserInteraction.chooseNPlayers();

        GameManager gameManager = new GameManager(nPlayer);
        gameManager.manageRound();

        boolean choose = InputData.readYesOrNo(TAUNT_TXT);
        if(choose) Taunt.translateBrixian();
    }

}
