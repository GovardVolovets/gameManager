package ru.netology.gameManager;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    private Player findPlayerByName(String playerName) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(playerName)) {
                return players.get(i);
            }
        }
        return null;
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
