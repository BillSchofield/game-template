package com.thoughtworks.gametemplate;

import com.thoughtworks.gametemplate.game.Game;
import com.thoughtworks.gametemplate.game.PlayerKeyListener;
import com.thoughtworks.gametemplate.game.QuitKeyListener;
import com.thoughtworks.gametemplate.game.entities.Entity;
import com.thoughtworks.gametemplate.game.entities.Vector2f;
import com.thoughtworks.gametemplate.physics.Physics;
import com.thoughtworks.gametemplate.game.entities.PlayerFactory;
import com.thoughtworks.gametemplate.game.entities.World;
import com.thoughtworks.gametemplate.physics.Box;
import com.thoughtworks.gametemplate.physics.Collisions;
import com.thoughtworks.gametemplate.rendering.ImageLoader;
import com.thoughtworks.gametemplate.rendering.Renderer;
import com.thoughtworks.gametemplate.rendering.Window;

import java.awt.Image;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.thoughtworks.gametemplate.game.entities.Vector2f.Zero;

public class Application {
    private Window window;
    private final World world;

    public Application(Vector2f gameSize) {
        Box bounds = new Box(Zero, gameSize);
        Renderer renderer = new Renderer(new ImageLoader().loadImage("starfield.png"), new ConcurrentHashMap<Entity, Image>());
        List<Entity> entities = new CopyOnWriteArrayList<>();
        List<Entity> graveYard = new CopyOnWriteArrayList<>();
        Physics physics = new Physics(new Collisions(graveYard));
        world = new World(bounds, entities, graveYard, renderer, physics);
        window = new Window(renderer, gameSize);
    }

    public void start() {

        PlayerKeyListener controls = new PlayerKeyListener();
        window.addKeyListener(controls);
        world.spawnEntity(new PlayerFactory(world, controls), new Vector2f(350, 470));

        Game game = new Game(world, window);
        QuitKeyListener untilUserQuits = new QuitKeyListener();
        window.addKeyListener(untilUserQuits);
        game.run(untilUserQuits);
    }

}
