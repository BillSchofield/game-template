package com.thoughtworks.gametemplate.game.entities;


import com.thoughtworks.gametemplate.game.*;
import com.thoughtworks.gametemplate.physics.Box;

import static com.thoughtworks.gametemplate.physics.Collision.Category.Player;

public class Player extends Entity {

    private final EntityFactory spawner;
    private World world;
    private PlayerKeyListener controls;
    private final static double rechargeTime = 0.5;
    private double rechargeTimeRemaining;

    public Player(World world, Vector2f position, Vector2f size, PlayerKeyListener controls) {
        super(position, size, Player);
        this.world = world;
        this.controls = controls;
        this.spawner = new ProjectileFactory(world);
        this.rechargeTimeRemaining = rechargeTime;
    }

    @Override
    public void update(double deltaTime) {
        desiredPosition = position.plus(controls.desiredMove());
        rechargeTimeRemaining -= deltaTime;
        if (controls.shouldFire()){
            if (rechargeTimeRemaining <= 0){
                Vector2f spawnLocation = position.plus(size.x()/2, 0);
                world.spawnEntity(spawner, spawnLocation);
                rechargeTimeRemaining = rechargeTime;
            }
        }
    }

    @Override
    public void move() {
        Box newBounds = desiredLocation();
        if (world.contains(newBounds)){
            super.move();
        }
    }
}
