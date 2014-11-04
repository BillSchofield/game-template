package com.thoughtworks.gametemplate.game;

import com.thoughtworks.gametemplate.render.Renderer;

import java.util.List;
import java.util.Random;

import static com.thoughtworks.gametemplate.game.EntityType.Enemy;
import static com.thoughtworks.gametemplate.game.Vector2f.Zero;

public class World {
    private List<Entity> entities;
    private Box bounds;
    private Collisions collisions;
    private final List<Entity> graveYard;
    private Renderer renderer;
    private long lastTime;
    private long timeSinceLastSpawn;

    public World(Box bounds, List<Entity> entities, Collisions collisions, List<Entity> graveYard, Renderer renderer) {
        this.entities = entities;
        this.bounds = bounds;
        this.collisions = collisions;
        this.graveYard = graveYard;
        this.renderer = renderer;
        this.lastTime = System.nanoTime();
    }

    public void update() {
        long time = System.nanoTime();
        long deltaTime = time - lastTime;
        lastTime = time;

        cleanupGraveyard();

        spawnEnemy(deltaTime);

        collideEntities();

        moveEntities();
    }

    private void spawnEnemy(long deltaTime) {
        timeSinceLastSpawn += deltaTime;
        if (timeSinceLastSpawn > 2000000000){
            Random random = new Random();
            spawnEntity(Enemy, new Vector2f(random.nextInt(700)+50, random.nextInt(300)));
            timeSinceLastSpawn = 0;
        }
    }

    private void moveEntities() {
        for (Entity entity : entities) {
            entity.move();
        }
    }

    private void cleanupGraveyard() {
        for (Entity deadEnemy : graveYard) {
            entities.remove(deadEnemy);
            renderer.remove(deadEnemy);
        }
    }

    private void collideEntities() {
        for (Entity firstEntity : entities) {
            Box firstEntityBounds = firstEntity.desiredLocation();
            for (Entity secondEntity : entities) {
                Box secondEntityBounds = secondEntity.desiredLocation();
                if (firstEntityBounds.intersects(secondEntityBounds)){
                    Collision collision = collisions.find(firstEntity, secondEntity);
                    collision.respond(firstEntity, secondEntity);
                }
            }
        }

    }

    public boolean contains(Box box) {
        return bounds.contains(box);
    }

    public Entity spawnEntity(EntityType type, Vector2f position) {
        Entity entity = type.createInstance(position, Zero, new Vector2f(type.width(), type.height()), this);
        renderer.addSprite(entity, type.image());
        entities.add(entity);
        return entity;
    }

    public void remove(Entity entity) {
        graveYard.add(entity);
    }

}
