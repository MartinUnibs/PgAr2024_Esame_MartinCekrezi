package it.unibs.arnaldo.tamagolem.game;

import java.util.ArrayDeque;
import java.util.Deque;

//TODO: DOC
public class Player {
    //TODO: everything here

    final String EMPTY_ROSTER = "No more tamagolem's to send in battle!";


    //TODO: String name per il giocatore?
    Deque <TamaGolem> roster;

    public Player(int nTamagolem, int stonePerTamaGolem) {

        roster = new ArrayDeque<TamaGolem>(); // se tamagolem 0 , Player perde

        for(int i=0; i < nTamagolem; i++){
            //TODO: Nome per il tamagolem?
            //Idea: Elemento + nome arnaldo random, " Kibo fiamma " oppure " Phoenix etereo " ecc
            roster.push(new TamaGolem(/* stonePerTamaGolem */));
        }
    }

    public Deque<TamaGolem> getRoster() {
        return roster;
    }

    public void removeFirstTamagolem() {
        if(!roster.isEmpty()){
            roster.pollFirst();
        } else {
            System.out.println(EMPTY_ROSTER); // colorare stringa ?
        }

    }
}
