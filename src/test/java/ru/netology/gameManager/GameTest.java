package ru.netology.gameManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private Player player1;
    private Player player2;
    private Player player3;

    @BeforeEach
    void setUp() {
        game = new Game();
        player1 = new Player(1, "Plr1", 100);
        player2 = new Player(2, "Plr2", 200);
        player3 = new Player(3, "Plr3", 100);
    }

    @Test
    void testRegister() {
        game.register(player1);
        assertEquals(0, game.round("Plr1", "Plr1"));
    }

    @Test
    void testRound() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        assertEquals(2, game.round("Plr1", "Plr2"));
        assertEquals(1, game.round("Plr2", "Plr1"));
        assertEquals(0, game.round("Plr1", "Plr3"));
    }

    @Test
    void testRoundNotRegisteredException() {
        game.register(player1);
        game.register(player2);

        assertThrows(NotRegisteredException.class, () -> game.round("Plr1", "Unknown"));
        assertThrows(NotRegisteredException.class, () -> game.round("Unknown", "Plr1"));
        assertThrows(NotRegisteredException.class, () -> game.round("Unknown1", "Unknown2"));
    }
}
