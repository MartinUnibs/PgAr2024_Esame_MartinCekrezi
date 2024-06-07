package it.unibs.arnaldo.bang.game;

import java.util.ArrayList;
import java.util.Stack;

public class Player {
    private String name;
    private int pf;
    private Role role;
    private Stack<Card> deck;

    public Player(String name, int pf) {
        this.name = name;
        this.pf = pf;
        this.deck = new Stack<>();
    }

    public void drawCard(Card card) {
        deck.push(card);
    }
    public void playCard(Card card) {
        //TODO: PLAY CARD
    }
    public void discard(Card card) {
        //TODO: DISCARD
    }

    public Stack<Card> getDeck() {
        return deck;
    }

    public int getPf() {
        return pf;
    }
    public void setPf(int pf) {
        this.pf = pf;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public String getName() {
        return name;
    }
}
