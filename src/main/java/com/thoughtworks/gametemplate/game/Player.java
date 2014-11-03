package com.thoughtworks.gametemplate.game;

import com.thoughtworks.gametemplate.render.Sprite;

public class Player extends Entity{

    public Player(Vector2f position, Vector2f velocity, Sprite sprite, World world, EntityType type) {
        super(position, velocity, sprite, world, type);
    }

    @Override
    public void move() {
        Box newBounds = desiredLocation();
        if (world.contains(newBounds)){
            super.move();
        }
    }
}
