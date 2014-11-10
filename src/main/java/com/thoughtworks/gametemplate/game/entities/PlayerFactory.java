package com.thoughtworks.gametemplate.game.entities;


import com.thoughtworks.gametemplate.game.PlayerKeyListener;

public class PlayerFactory extends EntityFactory {
    private World world;
    private PlayerKeyListener controls;

    public PlayerFactory(World world, PlayerKeyListener controls) {
        super("playerShip.png");
        this.world = world;
        this.controls = controls;
    }

    @Override
    Entity create(Vector2f position) {
        return new Player(world, position, size, controls);
    }
}
