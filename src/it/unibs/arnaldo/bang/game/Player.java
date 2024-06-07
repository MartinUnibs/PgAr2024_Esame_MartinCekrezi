package it.unibs.arnaldo.bang.game;

import java.util.ArrayList;

public class Player {
    private int pf;
    private Role role;
    private ArrayList<Card> deck;

    public Player(int pf, Role role) {
        this.pf = pf;
        this.role = role;
    }

    public void drawCard(Card card) {
        //TODO: DRAW CARD
    }
    public void playCard(Card card) {
        //TODO: PLAY CARD
    }
    public void discard(Card card) {
        //TODO: DISCARD
    }



    public int getPf() {
        return pf;
    }
    public void setPf(int pf) {
        this.pf = pf;
    }
}
