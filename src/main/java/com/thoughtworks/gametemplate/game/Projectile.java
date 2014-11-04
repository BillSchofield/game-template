package com.thoughtworks.gametemplate.game;

public class Projectile extends Entity {
    public Projectile(Vector2f position, Vector2f velocity, Vector2f size, World world, EntityType type) {
        super(position, velocity, size, world, type);
    }

    @Override
    public void move() {
        Box newBounds = desiredLocation();
        if (!world.contains(newBounds)){
            world.remove(this);
        }

        super.move();
    }
}
