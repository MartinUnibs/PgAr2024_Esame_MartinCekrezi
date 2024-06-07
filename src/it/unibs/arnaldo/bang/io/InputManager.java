package it.unibs.arnaldo.bang.io;

import com.google.gson.*;
import it.unibs.arnaldo.bang.game.Copy;
import it.unibs.arnaldo.bang.main.UserInteraction;

import com.google.gson.reflect.TypeToken;

import it.unibs.arnaldo.bang.game.Role;
import it.unibs.arnaldo.bang.game.Card;


import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InputManager {

    private static final String ERROR = "Fatal error in initializing the reader:\n";
    private static final String FILE = "assets/listaCarte.json";

    public InputManager() {
        // Costruttore vuoto
    }


    public ArrayList<Role> readRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        try (FileReader reader = new FileReader(FILE)) {
            JsonElement jsonElement = JsonParser.parseReader(reader);
            JsonArray rolesArray = jsonElement.getAsJsonObject().getAsJsonArray("roles");
            for (JsonElement roleElement : rolesArray) {
                String role = roleElement.getAsString();
                roles.add(new Role(role));
            }
        } catch (IOException e) {
            UserInteraction.fatalError("Error reading roles file: " + e.getMessage());
        }
        return roles;
    }


    public ArrayList<Card> readCards() {
        ArrayList<Card> deck = new ArrayList<>();
        try (FileReader reader = new FileReader("FILE_PATH_HERE")) {
            JsonElement jsonElement = JsonParser.parseReader(reader);
            JsonArray cardArrays = jsonElement.getAsJsonObject().getAsJsonArray("cards");
            for (JsonElement cardElement : cardArrays) {
                JsonObject cardObject = cardElement.getAsJsonObject();
                boolean equippable = cardObject.get("equippable").getAsBoolean();
                String name = cardObject.get("name").getAsString();
                String description = cardObject.get("description").getAsString();
                JsonArray copiesArray = cardObject.getAsJsonArray("copies");
                ArrayList<Copy> copies = new ArrayList<>();
                for (JsonElement copyElement : copiesArray) {
                    JsonObject copyObject = copyElement.getAsJsonObject();
                    String value = copyObject.get("value").getAsString();
                    String suit = copyObject.get("suit").getAsString();
                    copies.add(new Copy(value, suit));
                }
                deck.add(new Card(equippable, name, description, copies));
            }
        } catch (IOException e) {
            UserInteraction.fatalError("Error reading cards file: " + e.getMessage());
        }
        return deck;
    }


}
