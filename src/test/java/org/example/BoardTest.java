package org.example;

import org.example.renderable.Renderable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    //
    // After initialization Game should contain specific number of players (parameter)
    // Initial position of player can be random
    // Player cannot be placed on rock
    // Two Players cannot occupy the same location
    //

    @Test
    @DisplayName("board has a frame")
    public void frameCheck() {
        final var board = new Board(10, 10);

        final var checker = new FrameChecker();
        board.render(checker);
        assertTrue(checker.valid);
    }

    @Test
    @DisplayName("board is not empty internally")
    public void internalCheck() {
        final var board = new Board(10, 10);

        final var checker = new InternalChecker();
        board.render(checker);
        assertTrue(checker.valid);
    }

}

class InternalChecker implements Renderable {
    boolean valid = false;

    @Override
    public void render(char[][] tbl) {
        for (int j = 1; j < tbl.length - 1; j++) {
            for (int i = 1; i < tbl[j].length - 1; i++) {
                if (tbl[j][i] == 'x') {
                    valid = true;
                    return;
                }
            }
        }
    }
}

class FrameChecker implements Renderable {
    boolean valid = true;

    @Override
    public void render(char[][] tbl) {
        for (int j = 0; j < tbl.length; j++) {
            if (tbl[j][0] != 'x') {
                valid = false;
                return;
            }
            if (tbl[j][tbl[j].length - 1] != 'x') {
                valid = false;
                return;
            }
        }

        for (int i = 0; i < tbl[0].length; i++) {
            if (tbl[0][i] != 'x') {
                valid = false;
                return;
            }
        }

        for (int i = 0; i < tbl[tbl.length - 1].length; i++) {
            if (tbl[tbl.length - 1][i] != 'x') {
                valid = false;
                return;
            }
        }
    }
}
