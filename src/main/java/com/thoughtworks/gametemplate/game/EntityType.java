package com.thoughtworks.gametemplate.game;

import com.thoughtworks.gametemplate.render.ImageLoader;

import java.awt.Image;


public enum EntityType {
    Player("playerShip.png") {
        @Override
        public Entity createInstance(Vector2f position, Vector2f velocity, Vector2f size, World world) {
            return new Player(position, velocity, size, world, this);
        }
    },
    Enemy("enemyShip.png") {
        @Override
        public Entity createInstance(Vector2f position, Vector2f velocity, Vector2f size, World world) {
            return new Entity(position, velocity, size, world, this);
        }
    },
    Projectile("shot.png") {
        @Override
        public Entity createInstance(Vector2f position, Vector2f velocity, Vector2f size, World world) {
            return new Projectile(position, velocity, size, world, this);
        }
    },
    Background("starfield.png") {
        @Override
        public Entity createInstance(Vector2f position, Vector2f velocity, Vector2f size, World world) {
            return new Entity(position, velocity, size, world, this);
        }
    };

    protected Image image;

    EntityType(String imageName) {
        this.image = fromFile(imageName);
    }

    private static Image fromFile(String fileName){
        ImageLoader loader = new ImageLoader();
        return loader.loadImage(fileName);
    }

    public Image image() {
        return image;
    }

    public abstract Entity createInstance(Vector2f position, Vector2f velocity, Vector2f size, World world);

    public float width() {
        return image.getWidth(null);
    }

    public float height() {
        return image.getHeight(null);
    }
}
