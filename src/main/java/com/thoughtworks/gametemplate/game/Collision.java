package com.thoughtworks.gametemplate.game;

import java.util.List;

import static com.thoughtworks.gametemplate.game.EntityType.Enemy;
import static com.thoughtworks.gametemplate.game.EntityType.Projectile;

public interface Collision {
    public boolean is(Entity firstEntity, Entity secondEntity);
    public void respond(Entity firstEntity, Entity secondEntity);


    public static class ProjectileAndEnemyCollision implements Collision{
        private List graveYard;

        public ProjectileAndEnemyCollision(List<Entity> graveYard) {
            this.graveYard = graveYard;
        }

        public boolean is(Entity firstEntity, Entity secondEntity) {
            return isBothTypes(firstEntity, secondEntity, Projectile, Enemy);
        }

        public void respond(Entity firstEntity, Entity secondEntity) {
            graveYard.add(firstEntity);
            graveYard.add(secondEntity);
        }

        private static boolean isBothTypes(Entity firstEntity, Entity secondEntity, EntityType firstType, EntityType secondType) {
            return firstEntity.isType(firstType) && secondEntity.isType(secondType) ||
                    firstEntity.isType(secondType) && secondEntity.isType(firstType);
        }
    };

    public static class DefaultCollision implements Collision{
        public boolean is(Entity firstEntity, Entity secondEntity) {
            return true;
        }

        public void respond(Entity firstEntity, Entity secondEntity) {

        }
    };
}
