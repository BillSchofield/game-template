package com.thoughtworks.gametemplate.render;


import com.thoughtworks.gametemplate.game.Entity;
import com.thoughtworks.gametemplate.game.Vector2f;

import java.awt.*;
import java.util.Map;

public class Renderer {
    private Image background;
    private Map<Entity, Image> entitiesToSprites;

    public Renderer(Image background, Map<Entity, Image> entitiesToSprites) {
        this.background = background;
        this.entitiesToSprites = entitiesToSprites;
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(background, 0, 0, null);
        for (Entity entity : entitiesToSprites.keySet()) {
            Image image  = entitiesToSprites.get(entity);
            Vector2f position = entity.position();
            graphics.drawImage(image, position.x(), position.y(), null);
        }
    }

    public void addSprite(Entity entity, Image sprite) {
        entitiesToSprites.put(entity, sprite);
    }

    public void remove(Entity entity) {
        entitiesToSprites.remove(entity);
    }
}
