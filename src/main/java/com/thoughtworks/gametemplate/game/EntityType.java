package com.thoughtworks.gametemplate.game;

import com.thoughtworks.gametemplate.render.Sprite;

import static com.thoughtworks.gametemplate.game.Vector2f.Zero;

public enum EntityType {
    Player("playerShip.png") {
        @Override
        public Entity createInstance(Vector2f position, Vector2f velocity, Sprite sprite, World world) {
            return new Player(position, Zero, sprite, world, this);
        }
    },
    Enemy("enemyShip.png") {
        @Override
        public Entity createInstance(Vector2f position, Vector2f velocity, Sprite sprite, World world) {
            return new Entity(position, Zero, sprite, world, this);
        }
    },
    Projectile("shot.png") {
        @Override
        public Entity createInstance(Vector2f position, Vector2f velocity, Sprite sprite, World world) {
            return new Entity(position, Zero, sprite, world, this);
        }
    };

    protected String image;

    EntityType(String image) {
        this.image = image;
    }

    public String image() {
        return image;
    }

    public abstract Entity createInstance(Vector2f position, Vector2f velocity, Sprite sprite, World world);
}
