package com.company;

import java.util.Scanner;

public class GameMenu {

    private static final String STOP_GAME_INPUT = "s";
    private static final String MESSAGE = """
            Press any key (except 's') for next round.
            Press 's' for exit
            """;

    public void start() {
        var game = new Game();
        game.showPlayingField();

        var input = new Scanner(System.in);

        System.out.println(MESSAGE);

        while (!input.next().equalsIgnoreCase(STOP_GAME_INPUT)) {
            game.nextRound();
            System.out.println(MESSAGE);
        }
    }
}
