package org.example;

import org.example.renderable.Renderable;

import java.util.Random;

class Board {
    public final int width;
    public final int height;
    private final char[][] tbl;

    Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.tbl = new char[height][width];
        initialize();
    }

    private void initialize() {
        final var rg = new Random();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (0 < i && i < width - 1 && 0 < j && j < height - 1 && rg.nextDouble() < 0.8) {
                    tbl[j][i] = ' ';
                } else {
                    tbl[j][i] = 'x';
                }
            }
        }
    }

    public void render(Renderable renderable) {
        renderable.render(tbl);
    }
}
