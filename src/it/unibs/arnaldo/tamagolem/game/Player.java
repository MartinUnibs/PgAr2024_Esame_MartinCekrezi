package it.unibs.arnaldo.tamagolem.game;

import java.util.ArrayDeque;
import java.util.Deque;

//TODO: DOC
public class Player {
    //TODO: everything here

    //TODO: String name per il giocatore?
    Deque <TamaGolem> roster;

    public Player(int nTamagolem, int stonePerTamaGolem) {

        roster = new ArrayDeque<TamaGolem>();

        for(int i=0; i < nTamagolem; i++){
            //TODO: Nome per il tamagolem?
            //Idea: Elemento + nome arnaldo random, " Kibo fiamma " oppure " Phoenix etereo " ecc
            roster.push(new TamaGolem(/* stonePerTamaGolem */));
        }
    }

    public Deque<TamaGolem> getRoster() {
        return roster;
    }

}
