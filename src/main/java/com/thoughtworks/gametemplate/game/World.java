package com.thoughtworks.gametemplate.game;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.thoughtworks.gametemplate.game.EntityType.Enemy;
import static com.thoughtworks.gametemplate.game.EntityType.Projectile;

public class World {
    private List<Entity> entities;
    private Box bounds;

    public World(Box bounds, List<Entity> entities) {
        this.entities = entities;
        this.bounds = bounds;
    }

    public void update(Game game) {
        List<Entity> projectiles = entitiesByType(Projectile);
        collideProjectilesWithEnemies(game, projectiles);

        for (Entity projectile : projectiles) {
            projectile.move();
        }

        for (Entity player : entities) {
            Box entityBounds = player.desiredLocation();
            if (bounds.contains(entityBounds)){
                player.move();
            }
        }
    }

    private void collideProjectilesWithEnemies(Game game, List<Entity> projectiles) {
        List<Entity> graveYard = newArrayList();
        for (Entity projectile : projectiles) {
            Vector2f projectilePosition = projectile.position();
            List<Entity> enemies = entitiesByType(Enemy);
            for (Entity enemy : enemies) {
                Box enemyBounds = enemy.desiredLocation();
                if (enemyBounds.contains(projectilePosition)){
                    graveYard.add(enemy);
                }
            }
        }

        for (Entity deadEnemy : graveYard) {
            game.remove(deadEnemy);
        }
    }

    private List<Entity> entitiesByType(EntityType type) {
        List<Entity> filteredResult = newArrayList();
        for (Entity entity : entities) {
            if (entity.isType(type)){
                filteredResult.add(entity);
            }
        }

        return filteredResult;
    }

    public void spawn(Entity entity) {
        entities.add(entity);
    }

    public void remove(Entity entity) {
        entities.remove(entity);
    }
}
