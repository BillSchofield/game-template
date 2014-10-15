package com.thoughtworks.game_template.main;

import com.thoughtworks.game_template.physics.Entity;
import com.thoughtworks.game_template.game.Game;
import com.thoughtworks.game_template.physics.Physics;
import com.thoughtworks.game_template.render.Renderer;
import com.thoughtworks.game_template.render.Sprite;
import com.thoughtworks.game_template.render.Vector2d;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.thoughtworks.game_template.game.EntityType.*;
import static com.thoughtworks.game_template.game.EntityType.Player;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Renderer renderer = new Renderer(background());
        renderer.activate();

        List<Entity> entities = newArrayList();
        Physics physics = new Physics(entities);
        Game game = new Game(physics, renderer);
        game.spawnEntity(Player, new Vector2d(350, 500));
        game.spawnEntity(Enemy, new Vector2d(350, 50));
        game.spawnEntity(Shot, new Vector2d(350, 450));

        game.run();

        game.stop();
    }

    private static List<Sprite> background() {
        Sprite backgroundSprite = new Sprite(loadImage("starfield.png"), new Vector2d(0, 0));
        return newArrayList(backgroundSprite);
    }

    private static Image loadImage(String fileName) {
        ImageIcon imageIcon = new ImageIcon("src/main/resources/images/" + fileName);
        return imageIcon.getImage();
    }

}
