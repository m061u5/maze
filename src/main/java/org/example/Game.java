package org.example;

import org.example.renderable.Renderable;

import java.util.Random;

public class Game {
    private final Board board;

    private Player[] players;

    public Game(Board board, int numberOfPlayers) {
        this.board = board;
        initialize(numberOfPlayers);
    }

    public void render() {
        for (var player: players) {
            System.out.println("row: " + player.getLocation().y + ", column: " + player.getLocation().x);
        }
    }

    private void initialize(int numberOfPlayers) {
        players = new Player[numberOfPlayers];

        final var rg = new Random();
        outer: for (int i = 0; i < numberOfPlayers;) {
            final var point = new Point(rg.nextInt(board.height), rg.nextInt(board.width));
            if (!board.valid(point.y, point.x)) {
                continue;
            }

            for(int j = 0; j < i - 1; ++j) {
                if (players[j].getLocation().y == point.y && players[j].getLocation().x == point.x) {
                    continue outer;
                }
            }

            final var player = new Player("Player: " + i);
            player.setLocation(point);
            players[i] = player;
            i++;
        }
    }
}
