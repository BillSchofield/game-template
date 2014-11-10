package com.thoughtworks.gametemplate.game.entities;

import com.thoughtworks.gametemplate.physics.Box;

import static com.thoughtworks.gametemplate.physics.Collision.Category.Projectile;

public class Projectile extends Entity {
    private World world;

    public Projectile(World world, Vector2f position, Vector2f size) {
        super(position, size, Projectile);
        this.world = world;
    }

    @Override
    public void update(double deltaTime) {
        Box newBounds = desiredLocation();
        if (!world.contains(newBounds)){
            world.remove(this);
        }

        desiredPosition = position.plus(0, -10);
    }
}
