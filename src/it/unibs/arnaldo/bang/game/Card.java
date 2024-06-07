package it.unibs.arnaldo.bang.game;

import java.util.ArrayList;

public class Card {
    private boolean equippable;
    private String name;
    private String description;
    private ArrayList<Copy> copies;


    public Card(boolean equippable, String name, String description, ArrayList<Copy> copies) {
        this.equippable = equippable;
        this.name = name;
        this.description = description;
        this.copies = copies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
