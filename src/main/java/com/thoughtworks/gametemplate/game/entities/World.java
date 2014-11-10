package com.thoughtworks.gametemplate.game.entities;

import com.thoughtworks.gametemplate.physics.Box;
import com.thoughtworks.gametemplate.physics.Physics;
import com.thoughtworks.gametemplate.rendering.Renderer;

import java.util.List;
import java.util.Random;
/*

    Owns entities and controls their lifespan
 */
public class World {
    private final EntityFactory spawner;
    private List<Entity> entities;
    private Box bounds;
    private final List<Entity> graveYard;
    private Renderer renderer;
    private long lastTime;
    private double timeSinceLastSpawn;
    private Physics physics;

    public World(Box bounds, List<Entity> entities, List<Entity> graveYard, Renderer renderer, Physics physics) {
        this.entities = entities;
        this.bounds = bounds;
        this.graveYard = graveYard;
        this.renderer = renderer;
        this.physics = physics;
        this.lastTime = System.nanoTime();
        this.spawner = new EnemyFactory();
    }

    public void update() {
        double deltaTimeInSeconds = deltaTimeInSeconds();

        cleanupGraveyard();

        spawnEnemy(deltaTimeInSeconds);

        updateEntities(deltaTimeInSeconds);

        physics.move(entities);
    }

    private double deltaTimeInSeconds() {
        long time = System.nanoTime();
        double deltaTime = (double)(time - lastTime) / 1000000000.0;
        lastTime = time;
        return deltaTime;
    }

    private void spawnEnemy(double deltaTime) {
        timeSinceLastSpawn += deltaTime;
        if (timeSinceLastSpawn > 2){
            Random random = new Random();
            Vector2f position = new Vector2f(random.nextInt(700) + 50, random.nextInt(300));
            spawnEntity(spawner, position);
            timeSinceLastSpawn = 0;
        }
    }

    private void updateEntities(double deltaTime) {
        for (Entity entity : entities) {
            entity.update(deltaTime);
        }
    }

    private void cleanupGraveyard() {
        for (Entity deadEnemy : graveYard) {
            entities.remove(deadEnemy);
            renderer.remove(deadEnemy);
        }
    }

    public boolean contains(Box box) {
        return bounds.contains(box);
    }

    public void spawnEntity(EntityFactory factory, Vector2f position) {
        Entity entity = factory.create(position);
        entities.add(entity);
        renderer.addSprite(entity, factory.image());
    }

    public void remove(Entity entity) {
        graveYard.add(entity);
    }

}
