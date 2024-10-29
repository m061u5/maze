package org.example;

public class Player {
    private Point location;

    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }
}
