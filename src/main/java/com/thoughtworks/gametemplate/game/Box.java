package com.thoughtworks.gametemplate.game;

public class Box {
    private final Vector2f min;
    private final Vector2f max;

    public Box(Vector2f min, Vector2f max) {
        this.min = min;
        this.max = max;
    }

    public boolean contains(Box that) {
        return
            this.min.getX() < that.min.getX() &&
            this.min.getY() < that.min.getY() &&
            this.max.getX() > that.max.getX() &&
            this.max.getY() > that.max.getY();
    }

    public boolean contains(Vector2f point) {
        return contains(new Box(point, point));
    }
}
