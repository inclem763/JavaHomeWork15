package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Стамбул", 280);
    Player player2 = new Player(2, "Мюнхен", 270);
    Player player3 = new Player(3, "Копенгаген", 220);
    Player player4 = new Player(4, "Варшава", 232);
    Player player5 = new Player(5, "Осло", 299);
    Player player6 = new Player(6, "Хельсинки", 299);

    @Test
    public void shouldRegisterPlayersAndFirstWin() {
        game.register(player1);
        game.register(player2);
        int actual = 1;
        int expected = game.round("Стамбул", "Мюнхен");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRegisterPlayersAndSecondWin() {
        game.register(player3);
        game.register(player4);
        int actual = 2;
        int expected = game.round("Копенгаген", "Варшава");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRegisterAndRoundTheSamePlayers() {
        game.register(player5);
        game.register(player6);
        int actual = 0;
        int expected = game.round("Осло", "Хельсинки");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRegisterNotFoundFirst() {
        game.register(player3);
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Вена", "Варшава"));
    }

    @Test
    public void shouldRegisterNotFoundSecond() {
        game.register(player3);
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Копенгаген", "Талин"));
    }
}