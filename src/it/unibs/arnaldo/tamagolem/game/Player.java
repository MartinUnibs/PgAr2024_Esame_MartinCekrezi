package it.unibs.arnaldo.tamagolem.game;

import java.util.ArrayDeque;
import java.util.Deque;

//TODO: DOC
public class Player {

    Deque<TamaGolem> roster;

    public Player() {
        roster = new ArrayDeque<TamaGolem>();
    }

}

