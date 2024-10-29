package org.example.renderable;

public class ConsoleRendereable implements Renderable {
    @Override
    public void render(char[][] tbl) {
        for (int j = 0; j < tbl.length; j++) {
            for (int i = 0; i < tbl[j].length; i++) {
                System.out.print(tbl[j][i]);
            }
            System.out.println();
        }
    }
}
