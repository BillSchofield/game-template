package com.thoughtworks.gametemplate.game;

import com.thoughtworks.gametemplate.render.Sprite;

public class Entity {
    private Vector2f position;
    private Vector2f velocity;
    private Sprite sprite;
    protected World world;
    private EntityType type;

    public Entity(Vector2f position, Vector2f velocity, Sprite sprite, World world, EntityType type) {
        this.position = position;
        this.velocity = velocity;
        this.sprite = sprite;
        this.world = world;
        this.type = type;
    }


    public void move(){
        position = position.plus(velocity);
        sprite.move(position);
    }

    public void velocity(Vector2f velocity) {
        this.velocity = velocity;
    }

    public Box desiredLocation() {
        Vector2f desiredPosition = position.plus(velocity);
        return new Box(desiredPosition, desiredPosition.plus(sprite.width(), sprite.height()));
    }

    public void fire() {
        Vector2f spawnLocation = position.plus(sprite.width()/2, 0);
        Entity missile = world.spawnEntity(EntityType.Projectile, spawnLocation);
        missile.velocity(new Vector2f(0, -10));
    }

    public Sprite sprite() {
        return sprite;
    }

    public boolean isType(EntityType type) {
        return this.type == type;
    }
}
