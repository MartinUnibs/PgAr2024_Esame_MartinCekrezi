package it.unibs.arnaldo.bang.game;

import java.util.ArrayList;
import java.util.Stack;

public class Card {
    private boolean equippable;
    private String name;
    private String description;
    private Stack<Copy> copies;


    public Card(boolean equippable, String name, String description, Stack<Copy> copies) {
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
