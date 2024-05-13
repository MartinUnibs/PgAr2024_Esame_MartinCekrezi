package it.unibs.arnaldo.tamagolem.game;

import java.util.ArrayDeque;
import java.util.Deque;

//TODO: DOC
public class Player {
    //TODO: everything here

    private final String EMPTY_ROSTER = "No more tamagolems to send in battle!";

    private Deque<TamaGolem> roster;
    private int stonesPerTamaGolem;

    public Player(int nTamaGolem, int stonesPerTamaGolem) {
        this.stonesPerTamaGolem = stonesPerTamaGolem;
        roster = new ArrayDeque<TamaGolem>(); // se tamagolem 0 , Player perde

        for(int i=0; i < nTamaGolem; i++){
            roster.push(new TamaGolem());
        }
    }

    public Deque<TamaGolem> getRoster() {
        return roster;
    }

    public boolean canPlay() {
        return !roster.isEmpty();
    }

    public TamaGolem getCurrentTamagolem() {
        return roster.peekFirst(); // Return null if empty doest not remove
    }

    public void removeCurrentTamagolem() {
        if(!roster.isEmpty()){
            roster.pollFirst(); //remove first
        } else {
            System.out.println(EMPTY_ROSTER); // colorare stringa ?
        }
    }

    public void summonTamaGolem() {
        //TODO: assign stones to tamagolem - quando lo cambiamo il tamagolem corrente ???
        for (int i = 0; i < stonesPerTamaGolem; i++) {

        }
    }

    // per test ??
     public void printRoster(){
        for(TamaGolem t : roster){
            System.out.println(t);
        }
     }

     //TODO: create canPlay method.
}
