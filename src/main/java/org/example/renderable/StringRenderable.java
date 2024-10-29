package org.example.renderable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StringRenderable implements Renderable {
    private String s;

    @Override
    public void render(char[][] tbl) {
        s = "";
        for (int j = 0; j < tbl.length; j++) {
            for (int i = 0; i < tbl[j].length; i++) {
                s = s + tbl[j][i];
            }
            s = s + System.lineSeparator();
        }
    }

    public String get() {
        return s;
    }
}
