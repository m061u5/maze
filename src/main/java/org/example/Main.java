package org.example;

// game: OnlyOne
// write a class representing game Board (for our Maze exploration game)
// two-dimensional, each field is character with values ' ', 'x'
// initialize state of board (not only empty space)
// board size should be parametrized at construction time i.e. width, height
// add usage example

// create interface to render board, possible options (implementtions):
// draw a board to console
// draw (save) board to file
// draw (save) to String

import org.example.renderable.ConsoleRendereable;
import org.example.renderable.FileRenderable;
import org.example.renderable.Renderable;
import org.example.renderable.StringRenderable;

public class Main {
    public static void main(String[] args) {
        final var board = new Board(7, 5);

        Renderable consoleRenderable = new ConsoleRendereable();
        board.render(consoleRenderable);

        Renderable fileRenderable = new FileRenderable("./board.txt");
        board.render(fileRenderable);

        StringRenderable stringRenderable = new StringRenderable();
        board.render(stringRenderable);

        System.out.println(stringRenderable.get());

        System.out.println("board is " + board.width + " x " + board.height);
    }
}

