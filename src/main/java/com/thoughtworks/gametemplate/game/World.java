package com.thoughtworks.gametemplate.game;

import com.thoughtworks.gametemplate.render.Renderer;
import com.thoughtworks.gametemplate.render.Sprite;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.thoughtworks.gametemplate.game.Vector2f.Zero;
import static com.thoughtworks.gametemplate.render.Sprite.fromFile;

public class World {
    private List<Entity> entities;
    private Box bounds;
    private Collisions collisions;
    private final List<Entity> graveYard;
    private Renderer renderer;

    public World(Box bounds, List<Entity> entities, Collisions collisions, List<Entity> graveYard, Renderer renderer) {
        this.entities = entities;
        this.bounds = bounds;
        this.collisions = collisions;
        this.graveYard = graveYard;
        this.renderer = renderer;
    }

    public void update(Game game) {
        destroyGraveyard(game);

        collideProjectilesWithEnemies(game);

        for (Entity entity : entities) {
            entity.move();
        }
    }

    private void destroyGraveyard(Game game) {
        for (Entity deadEnemy : graveYard) {
            remove(deadEnemy);
        }
    }

    private void collideProjectilesWithEnemies(Game game) {
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
        Sprite sprite = fromFile(type.image(), position);
        renderer.addSprite(sprite);
        Entity entity = type.createInstance(position, Zero, sprite, this);
        entities.add(entity);
        return entity;
    }

    public void remove(Entity entity) {
        entities.remove(entity);
        renderer.remove(entity.sprite());
    }

}
