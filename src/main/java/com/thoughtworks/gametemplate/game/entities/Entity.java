package com.thoughtworks.gametemplate.game.entities;


import com.thoughtworks.gametemplate.physics.Box;

import static com.thoughtworks.gametemplate.physics.Collision.Category;

public abstract class Entity {
    protected Vector2f position;
    private Category type;
    protected Vector2f size;
    protected Vector2f desiredPosition;

    public Entity(Vector2f position, Vector2f size, Category type) {
        this.position = position;
        this.desiredPosition = position;
        this.size = size;
        this.type = type;
    }


    public abstract void update(double deltaTime);

    public void move(){
        position = desiredPosition;
    }

    public Vector2f position() {
        return position;
    }

    public Box desiredLocation() {
        return new Box(desiredPosition, desiredPosition.plus(size));
    }

    public boolean isType(Category type) {
        return this.type == type;
    }
}
