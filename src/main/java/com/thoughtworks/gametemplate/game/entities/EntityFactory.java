package com.thoughtworks.gametemplate.game.entities;

import com.thoughtworks.gametemplate.rendering.ImageLoader;

import java.awt.Image;


public abstract class EntityFactory {
    protected Image image;
    protected Vector2f size;
    protected ImageLoader imageLoader = new ImageLoader();

    EntityFactory(String imageName) {
        this.image = imageLoader.loadImage(imageName);
        this.size = new Vector2f(image.getWidth(null), image.getHeight(null));
    }

    abstract Entity create(Vector2f position);

    public Image image() {
        return image;
    }
}
