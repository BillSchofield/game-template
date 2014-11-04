package com.thoughtworks.gametemplate;

import com.thoughtworks.gametemplate.game.*;
import com.thoughtworks.gametemplate.render.Renderer;
import com.thoughtworks.gametemplate.render.Window;

import java.awt.Image;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.google.common.collect.Lists.newArrayList;
import static com.thoughtworks.gametemplate.game.EntityType.Background;
import static com.thoughtworks.gametemplate.game.EntityType.Player;
import static com.thoughtworks.gametemplate.game.Vector2f.Zero;

public class Application {
    private Window window;
    private final World world;
    private final List<Entity> entities = new CopyOnWriteArrayList<Entity>();
    private final List<Entity> graveYard = new CopyOnWriteArrayList<Entity>();

    public Application(Vector2f gameSize) {
        Box bounds = new Box(Zero, gameSize);
        Renderer renderer = new Renderer(Background.image(), new ConcurrentHashMap<Entity, Image>());
        world = new World(bounds, entities, new Collisions(graveYard), graveYard, renderer);
        window = new Window(renderer, gameSize);
    }

    public void start() {
        Entity player = world.spawnEntity(Player, new Vector2f(350, 470));
        QuitKeyListener untilUserQuits = addKeyListeners(player);

        Game game = new Game(world, window);
        game.run(untilUserQuits);
    }

    private QuitKeyListener addKeyListeners(Entity player) {
        QuitKeyListener untilUserQuits = new QuitKeyListener();
        window.addKeyListener(untilUserQuits);
        window.addKeyListener(new PlayerMoveKeyListener(player));
        return untilUserQuits;
    }

}
