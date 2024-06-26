package it.unibs.arnaldo.bang.game;

import it.kibo.fp.lib.AnsiColors;
import it.kibo.fp.lib.RandomDraws;
import it.unibs.arnaldo.bang.io.InputManager;
import it.unibs.arnaldo.bang.main.UserInteraction;

import java.util.*;

public class GameManager {
    private static final String SHERIFF_TRUE = "The Sheriff is: %d";
    private static final String SHERIFF_FALSE = "There isn't any Sheriff";
    private static final int PF_DEF = 4;
    private static final String[] PLAYER_NAMES = {
            "Marco",
            "Luigi",
            "Apo",
            "Kibo",
            "Martin Routher King",
            "Time Limit",
            "Arnaldo generico"
    };
    private static final String DRAW_MESSAGE = "You draw a card from the deck!";
    private static final String DRAW_MESSAGE_2 = "You drew 2 cards from the deck!";
    private static final String PLAY_MESSAGE = "Select what card to use: ";

    //TODO: DOC
    private int nPlayer;
    private ArrayList<Player> players;
    private ArrayList<Role> roles;

    public Stack<Card> deck = loadDeck();


    public GameManager(int nPlayer) {
        this.nPlayer = nPlayer;
        this.players = new ArrayList<>();
        this.roles = new ArrayList<>();
    }

    public void manageRound(){
        setRoles();
        setPlayers();

        //TODO: MESS + PESCA CARTA
        UserInteraction.printColoredMessage(DRAW_MESSAGE_2, AnsiColors.YELLOW);
        int myPlayerIndex = RandomDraws.drawInteger(0 , nPlayer - 1);
        Player myPlayer = players.get(myPlayerIndex);
        for (int i = 0; i < 2;i++){
            drawFromDeck(deck,myPlayer);
        }
        UserInteraction.printColoredMessage(PLAY_MESSAGE, AnsiColors.YELLOW);

        for(int i = 0; i < myPlayer.getDeck().size();i++){
            myPlayer.getDeck().peek();
        }
        //TODO:GIOCA CARTE
        //TODO: SCARTA CARTE
    }


    public void setPlayers() {
        this.players = generatePlayers();
    }

    public void setRoles() {
        this.roles = generateRoles();
    }

    private boolean checkRole(String role){
        for (Player player : players) {
            if (Objects.equals(player.getRole(), role)) {
                return true;
            }
        }
        return false;
    }


    public void showSherif(){
        if(checkRole("Sheriff")){
            UserInteraction.printColoredMessage(SHERIFF_TRUE, AnsiColors.GREEN);
        } else {
            UserInteraction.printColoredMessage(SHERIFF_FALSE, AnsiColors.RED);
        }

    }

    public int getnPlayer() {
        return nPlayer;
    }

    private ArrayList<Player> generatePlayers() {

        ArrayList<String> shuffledNames = new ArrayList<>(Arrays.asList(PLAYER_NAMES));
        Collections.shuffle(shuffledNames);

        for(int i = 0; i < nPlayer; i++){
            Player player = new Player(shuffledNames.get(i), PF_DEF);
            players.add(player);
        }

        players.get(0).setRole(roles.get(0));
        players.get(0).setPf(PF_DEF + 1);

        players.get(1).setRole(roles.get(3));
        int numOutlaws = Math.min(nPlayer - 2, 2);
        int numVices = Math.min(nPlayer - 2 - numOutlaws, 2);
        int index = 2;
        for (int i = 0; i < numOutlaws; i++) {
            players.get(index++).setRole(roles.get(1));
        }
        for (int i = 0; i < numVices; i++) {
            players.get(index++).setRole(roles.get(2));
        }

        if(nPlayer == 7){
            players.get(6).setRole(roles.get(1));
        }
        int maxCard = PF_DEF -1;
        for(int i = 0; i < players.size();i++){
            if(players.get(i).getRole().equals(roles.getFirst())){
                maxCard += 1;
            } else {
                maxCard = PF_DEF -1;
            }
            for (int j=0; j < maxCard; j++) {
                drawFromDeck(deck,players.get(j));
            }
        }

        return players;
    }

    private ArrayList<Role> generateRoles() {
        InputManager inputManager = new InputManager();
        return inputManager.readRoles();
    }

    private Stack<Card> loadDeck(){
        InputManager inputManager = new InputManager();
        return inputManager.readDeck();
    }

    public void drawFromDeck(Stack<Card> deck , Player player) {

        int deckSize = 0;
        for (Card card : deck) {
            deckSize += card.getCopySize();
        }

        int indexDraw = RandomDraws.drawInteger(0, deckSize -1);
        int currentIndex = 0;
        for (Card card : deck) {
            int cardCopySize = card.getCopySize();
            if (indexDraw < currentIndex + cardCopySize) {
                Copy drawnCopy = card.removeCopy();
                player.drawCard(card);
                if (card.getCopySize() == 0) {
                    deck.remove(card);
                }
                break;
            }
            currentIndex += cardCopySize;
        }
    }

}
