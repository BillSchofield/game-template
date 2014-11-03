package com.thoughtworks.gametemplate.game;

public enum EntityType {
    Player("playerShip.png"),
    Enemy("enemyShip.png"),
    Projectile("shot.png");

    protected String image;

    EntityType(String image) {
        this.image = image;
    }

    public String image() {
        return image;
    }
}
