package com.thoughtworks.gametemplate;

import com.thoughtworks.gametemplate.game.*;
import com.thoughtworks.gametemplate.render.Renderer;
import com.thoughtworks.gametemplate.render.Window;
import com.thoughtworks.gametemplate.render.Sprite;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.thoughtworks.gametemplate.game.EntityType.Enemy;
import static com.thoughtworks.gametemplate.game.EntityType.Player;
import static com.thoughtworks.gametemplate.game.Vector2f.Zero;
import static com.thoughtworks.gametemplate.render.Sprite.fromFile;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Vector2f gameSize = new Vector2f(800.0f, 600.0f);
        Box bounds = new Box(Zero, gameSize);
        List<Entity> entities = newArrayList();
        List<Entity> graveYard = newArrayList();
        Sprite background = fromFile("starfield.png", new Vector2f(0.0f, 0.0f));
        Renderer renderer = new Renderer(newArrayList(background));
        World world = new World(bounds, entities, new Collisions(graveYard), graveYard, renderer);
        Window window = new Window(renderer, gameSize);

        QuitKeyListener user = new QuitKeyListener();

        Game game = new Game(world, window, user);
        Entity player = world.spawnEntity(Player, new Vector2f(350.0f, 470.0f));
        world.spawnEntity(Enemy, new Vector2f(350.0f, 50.0f));

        window.addKeyListener(user);
        window.addKeyListener(new PlayerMoveKeyListener(player));

        game.run();

    }
}
