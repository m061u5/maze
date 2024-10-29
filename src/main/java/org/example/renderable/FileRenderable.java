package org.example.renderable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileRenderable implements Renderable {
    private final String filePath;

    public FileRenderable(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void render(char[][] tbl) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (char[] row : tbl) {
                writer.write(row); // Write each row to the file
                writer.newLine(); // Add a new line after each row
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
