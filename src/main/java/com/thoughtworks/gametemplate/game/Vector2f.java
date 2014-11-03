package com.thoughtworks.gametemplate.game;

public class Vector2f {
    public static Vector2f Zero = new Vector2f(0, 0);
    private final float x;
    private final float y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return (int)x;
    }

    public int y() {
        return (int)y;
    }

    public Vector2f scale(float scalar) {
        return new Vector2f(x * scalar, y * scalar);
    }

    public Vector2f plus(float x, float y) {
        return new Vector2f(this.x + x, this.y + y);
    }

    public Vector2f plus(Vector2f that) {
        return new Vector2f(this.x + that.x, this.y + that.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector2f vector2f = (Vector2f) o;

        if (Float.compare(vector2f.x, x) != 0) return false;
        if (Float.compare(vector2f.y, y) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (x != +0.0f ? Float.floatToIntBits(x) : 0);
        result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        return result;
    }

}
