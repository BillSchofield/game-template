package com.thoughtworks.gametemplate.physics;

import com.thoughtworks.gametemplate.game.entities.Entity;
import com.thoughtworks.gametemplate.physics.Box;
import com.thoughtworks.gametemplate.physics.Collision;
import com.thoughtworks.gametemplate.physics.Collisions;

import java.util.List;

public class Physics {
    private Collisions collisions;

    public Physics(Collisions collisions) {
        this.collisions = collisions;
    }


    public void move(List<Entity> entities) {
        collide(entities);
        updatePosition(entities);
    }

    private void updatePosition(List<Entity> entities) {
        for (Entity entity : entities) {
            entity.move();
        }
    }

    private void collide(List<Entity> entities) {
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
}
