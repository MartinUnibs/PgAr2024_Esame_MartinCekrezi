package it.unibs.arnaldo.bang.game;

import it.unibs.arnaldo.bang.io.InputManager;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        this.deck = loadDeck();
    }

    private ArrayList<Card> loadDeck(){
        InputManager inputManager = new InputManager();
        return inputManager.readCards();
    }
}
