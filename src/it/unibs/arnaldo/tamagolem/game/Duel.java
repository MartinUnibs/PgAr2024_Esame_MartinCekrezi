package it.unibs.arnaldo.tamagolem.game;

import it.unibs.arnaldo.tamagolem.graph.BalanceManager;

import java.util.*;

//TODO: DOC - spiegare perché viene utilizzata una lista
public class Duel {

    List<Element> elements;
    Map<Element, Integer> stones;
    Player p1;
    Player p2;
    BalanceManager balance;

    public Duel(int difficulty) {
        // Element choice based on difficulty
        int start = 0; //TODO: random
        int end = start + difficulty;
        elements = List.of(Arrays.copyOfRange(Element.values(), start, end));
        //TODO: to refactor.
        int stonePerTamaGolem = (int) Math.ceil((double) (difficulty + 1) / 3) + 1;
        int nTamaGolem = (int) Math.ceil((double) ((difficulty - 1) * (difficulty - 2)) / (2 * stonePerTamaGolem));
        // Stone reserve initialization
        int amount = (int) Math.ceil((double) (2 * nTamaGolem * stonePerTamaGolem) / difficulty); // TODO: calcolo numero di pietre per elemento
        for (Element element : elements) {
            stones.put(element, amount);
        }
        // Players initialization
        Player p1 = new Player(nTamaGolem, stonePerTamaGolem); //TODO: number of tamagolem, P;
        Player p2 = new Player(nTamaGolem, stonePerTamaGolem); //TODO: number of tamagolem, P;
        this.balance = new BalanceManager(difficulty);
    }

    public void start() {
        //TODO: winner
        setup();
        fight();
        end();
        //TODO: da finire ??
    }

    public void setup() {
        //TODO: here
        //Nel metodo setup, vengono richiamati i metodi per la creazione del grafo.
    }

    public void fight() { //TODO: ritorna il vincitore
        //TODO: here
        /*
        * do {
        * si scontranto
        * } while (p1.puo.giocare && p2.puo.giocare);
        * */
    }

    public void end() { //TODO: param
        //TODO: here
    }
}
