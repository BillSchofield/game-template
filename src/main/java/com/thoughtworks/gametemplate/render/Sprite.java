package com.thoughtworks.gametemplate.render;

import com.thoughtworks.gametemplate.game.Vector2f;

import java.awt.Image;
import java.awt.Graphics;

public class Sprite {
    private Image image;
    private Vector2f position;

    public static Sprite fromFile(String fileName, Vector2f position){
        ImageLoader loader = new ImageLoader();
        return new Sprite(loader.loadImage(fileName), position);
    }

    Sprite(Image image, Vector2f position) {
        this.image = image;
        this.position = position;
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(image, position.x(), position.y(), null);
    }

    public void move(Vector2f position) {
        this.position = position;
    }

    public int width() {
        return image.getWidth(null);
    }

    public int height() {
        return image.getHeight(null);
    }
}
