package com.thoughtworks.gametemplate.physics;

import com.thoughtworks.gametemplate.game.entities.Entity;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.thoughtworks.gametemplate.physics.Collision.ProjectileAndEnemyCollision;

public class Collisions {

    private Collision defaultCollision;
    private List<Collision> collisions;

    public Collisions(List<Entity> graveYard) {
        defaultCollision = new Collision.DefaultCollision();

        collisions = newArrayList(
                new ProjectileAndEnemyCollision(graveYard),
                defaultCollision
        );
    }

    public Collision find(Entity firstEntity, Entity secondEntity) {
        for (Collision collision : collisions) {
            if(collision.is(firstEntity, secondEntity)){
                return collision;
            }
        }
        return defaultCollision;
    }

}
