package com.thoughtworks.gametemplate.game.entities;

import com.thoughtworks.gametemplate.physics.Collision;

public class Enemy extends Entity {
    public Enemy(Vector2f position, Vector2f size) {
        super(position, size, Collision.Category.Enemy);
    }

    @Override
    public void update(double deltaTime) {

    }
}
