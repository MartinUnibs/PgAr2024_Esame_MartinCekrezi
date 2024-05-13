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
        // Stone reserve initialization
        int amount = 0; // TODO: calcolo numero di pietre per elemento
        for (Element element : elements) {
            stones.put(element, amount);
        }
        // Players initialization
        Player p1 = new Player(); //TODO: number of tamagolem, P;
        Player p2 = new Player(); //TODO: number of tamagolem, P;
        //TODO: balance
    }

    public void start() {
        setup();
        fight();
        end();
        //TODO: da finire ??
    }

    public void setup() {
        //TODO: here
    }

    public void fight() {
        //TODO: here
    }

    public void end() {
        //TODO: here
    }
}
