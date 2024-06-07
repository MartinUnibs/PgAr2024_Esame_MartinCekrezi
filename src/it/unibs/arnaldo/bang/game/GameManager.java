package it.unibs.arnaldo.bang.game;

import java.util.ArrayList;

public class GameManager {
    //TODO: DOC
    private int nPlayer;
    private ArrayList<Player> players;
    private ArrayList<Role> roles;

    public GameManager(int nPlayer) {
        this.nPlayer = nPlayer;
        this.players = generatePlayers();
        this.roles = generateRoles();
    }

    public void showSherif(){
        //TODO:SHOW SHERIF
    }
    public void showCard(){
        //TODO: SHOW CARDS
    }

    public int getnPlayer() {
        return nPlayer;
    }

    public void setnPlayer(int nPlayer) {
        this.nPlayer = nPlayer;
    }

    private ArrayList<Player> generatePlayers() {
        //TODO: GENERATE PLAYERS
        return null;
    }

    private ArrayList<Role> generateRoles() {
        //TODO: GENERATE ROLES

        return null;
    }

}
