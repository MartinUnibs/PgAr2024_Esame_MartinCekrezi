package it.unibs.arnaldo.tamagolem.game;

import it.kibo.fp.lib.RandomDraws;
import it.unibs.arnaldo.tamagolem.graph.BalanceManager;

import java.util.*;

//TODO: DOC - spiegare perché viene utilizzata una lista
public class Duel {

    private static final int ELEMENT_DRAW_MIN = 0;
    private static final int ELEMENT_DRAW_MAX = 10;
    private static final int FIRST_PLAYER_WIN = 1;
    private static final int SECOND_PLAYER_WIN = 2;

    List<Element> elements;
    Map<Element, Integer> stones;
    Player p1;
    Player p2;
    BalanceManager balance;

    public Duel(int difficulty) {
        // Element choice based on difficulty
        int start = RandomDraws.drawInteger(ELEMENT_DRAW_MIN,  ELEMENT_DRAW_MAX - difficulty);
        int end = start + difficulty;
        elements = List.of(Arrays.copyOfRange(Element.values(), start, end));
        // Parameters calculations
        int stonePerTamaGolem = (int) Math.ceil((double) (difficulty + 1) / 3) + 1;
        int nTamaGolem = (int) Math.ceil((double) ((difficulty - 1) * (difficulty - 2)) / (2 * stonePerTamaGolem));
        // Stone reserve initialization
        int amount = (int) Math.ceil((double) (2 * nTamaGolem * stonePerTamaGolem) / difficulty);
        for (Element element : elements) {
            stones.put(element, amount);
        }
        // Players initialization
        Player p1 = new Player(nTamaGolem, stonePerTamaGolem);
        Player p2 = new Player(nTamaGolem, stonePerTamaGolem);
    }

    public void start() {
        setup();
        int winner = fight();
        end(winner);
    }

    private void setup() {
        this.balance = new BalanceManager(elements.size());
        //TODO: add a message (ex. "Gli equilibri del mondo sono stati generati ecc...")
    }

    private int fight() {
        p1.summonTamaGolem();
        p2.summonTamaGolem();
        do {
            if (p1.getCurrentTamaGolem().isDead()) {
                p1.summonTamaGolem();
            } else if (p2.getCurrentTamaGolem().isDead()) {
                p2.summonTamaGolem();
            }
            while (!p1.getCurrentTamaGolem().isDead() && !p2.getCurrentTamaGolem().isDead()){
                //TODO: turn management.
                int e1 = elements.indexOf(p1.getCurrentTamaGolem().throwStone());
                int e2 = elements.indexOf(p2.getCurrentTamaGolem().throwStone());
                int damage = balance.getDamage(e1, e2);
                if (damage < 0) { //TODO: refactor ??
                    //TODO: messaggio all'utente - DANNI A P1
                    p1.getCurrentTamaGolem().hit(Math.abs(damage));
                } else if (damage == 0) {
                    //TODO: messaggio all'utente - NO DANNI
                } else {
                    //TODO: messaggio all'utente - DANNI A P2
                    p2.getCurrentTamaGolem().hit(Math.abs(damage));
                }
            }
        } while (p1.canPlay() && p2.canPlay());
        if (p1.canPlay()) {
            return FIRST_PLAYER_WIN;
        } else {
            return SECOND_PLAYER_WIN;
        }
    }

    private void end(int winner) {
        //TODO: here
        // 1. dichiara il vincitore
        // 2. mostra equilibro agli utenti
    }
}
