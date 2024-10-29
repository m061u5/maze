package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void basic() {
        final var game = new Game(new Board(10, 10), 3);
        game.render();
    }

}