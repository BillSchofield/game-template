package com.thoughtworks.gametemplate.game;

import com.thoughtworks.gametemplate.game.entities.World;
import com.thoughtworks.gametemplate.rendering.*;

public class Game {
    private World world;
    private Window window;

    public Game(World world, Window window) {
        this.world = world;
        this.window = window;
    }

    public void run(QuitKeyListener user) {
        window.activate();

        sleep(500);
        while(!user.hasQuit()){
            world.update();
            window.repaint();
            sleep(25);
        }

        window.deactivate();
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
