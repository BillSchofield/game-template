package com.thoughtworks.gametemplate.game.entities;

public class ProjectileFactory extends EntityFactory {
    private World world;

    public ProjectileFactory(World world) {
        super("shot.png");
        this.world = world;
    }

    @Override
    Entity create(Vector2f position) {
        return new Projectile(world, position, size);
    }
}
