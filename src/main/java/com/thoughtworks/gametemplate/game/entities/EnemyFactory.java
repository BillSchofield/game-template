package com.thoughtworks.gametemplate.game.entities;

public class EnemyFactory extends EntityFactory {
    public EnemyFactory() {
        super("enemyShip.png");
    }

    @Override
    Entity create(Vector2f position) {
        return new Enemy(position, size);
    }
}
