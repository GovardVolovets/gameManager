package ru.netology.gameManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    private Player findPlayerByName(String playerName) {
        return players.get(playerName);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findPlayerByName(playerName1);
        Player player2 = findPlayerByName(playerName2);

        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("player not registered");
        }

        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        }

        return player1.getStrength() > player2.getStrength() ? 1 : 2;
    }
}
