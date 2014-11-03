package com.thoughtworks.gametemplate.render;


import java.awt.Graphics;
import java.util.List;

public class Renderer {
    private List<Sprite> sprites;

    public Renderer(List<Sprite> sprites) {
        this.sprites = sprites;
    }

    public void draw(Graphics graphics) {
        for (Sprite sprite : sprites) {
            sprite.draw(graphics);
        }
    }

    public void addSprite(Sprite sprite) {
        sprites.add(sprite);
    }

    public void remove(Sprite sprite) {
        sprites.remove(sprite);
    }
}
