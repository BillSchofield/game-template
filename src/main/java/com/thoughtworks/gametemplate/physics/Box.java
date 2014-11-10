package com.thoughtworks.gametemplate.physics;

import com.thoughtworks.gametemplate.game.entities.Vector2f;

public class Box {
    private final Vector2f min;
    private final Vector2f max;

    public Box(Vector2f min, Vector2f max) {
        this.min = min;
        this.max = max;
    }

    public boolean contains(Box that) {
        return
            this.min.x() < that.min.x() &&
            this.min.y() < that.min.y() &&
            this.max.x() > that.max.x() &&
            this.max.y() > that.max.y();
    }

    public boolean contains(Vector2f point) {
        return contains(new Box(point, point));
    }

    public boolean intersects(Box that) {
        return !(
                that.min.x() > this.max.x() ||
                that.max.x() < this.min.x() ||
                that.min.y() > this.max.y() ||
                that.max.y() < this.min.y()
        );
    }
}
