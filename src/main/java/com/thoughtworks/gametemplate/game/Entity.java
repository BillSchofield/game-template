package com.thoughtworks.gametemplate.game;

import static com.thoughtworks.gametemplate.game.EntityType.Projectile;

public class Entity {
    private Vector2f position;
    private Vector2f velocity;
    protected World world;
    private EntityType type;
    private Vector2f size;

    public Entity(Vector2f position, Vector2f velocity, Vector2f size, World world, EntityType type) {
        this.position = position;
        this.velocity = velocity;
        this.size = size;
        this.world = world;
        this.type = type;
    }


    public void move(){
        position = position.plus(velocity);
    }

    public Vector2f position() {
        return position;
    }

    public void velocity(Vector2f velocity) {
        this.velocity = velocity;
    }

    public Box desiredLocation() {
        Vector2f desiredPosition = position.plus(velocity);
        return new Box(desiredPosition, desiredPosition.plus(size));
    }

    public void fire() {
        Vector2f spawnLocation = position.plus(size.x()/2, 0);
        Entity missile = world.spawnEntity(Projectile, spawnLocation);
        missile.velocity(new Vector2f(0, -10));
    }

    public boolean isType(EntityType type) {
        return this.type == type;
    }
}
