package it.unibs.arnaldo.bang.game;

import it.unibs.arnaldo.bang.io.InputManager;

import java.util.ArrayList;
import java.util.Stack;

public class Deck {
    private Stack<Card> deck;

    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + deck +
                '}';
    }

    public Deck(Stack<Card> deck) {
        this.deck = deck;
    }

}
