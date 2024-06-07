package it.unibs.arnaldo.bang.game;

import java.util.ArrayList;

public class Player {
    private String name;
    private int pf;
    private Role role;
    private ArrayList<Card> deck;

    public Player(String name, int pf) {
        this.name = name;
        this.pf = pf;
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
