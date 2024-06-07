package it.unibs.arnaldo.bang.game;

public class Card {
    String name;
    String cardType;
    String cardEffect;
    public Card(String name, String cardType, String cardEffect) {
        this.name = name;
        this.cardType = cardType;
        this.cardEffect = cardEffect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
