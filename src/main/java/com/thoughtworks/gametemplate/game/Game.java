package com.thoughtworks.gametemplate.game;

import com.thoughtworks.gametemplate.render.*;
import com.thoughtworks.gametemplate.render.Renderer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.thoughtworks.gametemplate.game.Vector2f.Zero;
import static com.thoughtworks.gametemplate.render.Sprite.fromFile;

public class Game {
    private World world;
    private Window window;
    private QuitKeyListener user;

    public Game(World world, Window window, QuitKeyListener user) {
        this.world = world;
        this.window = window;
        this.user = user;
    }

    public void run() throws InterruptedException {
        window.activate();

        Thread.sleep(500);
        while(!user.hasQuit()){
            world.update(this);
            window.repaint();
            Thread.sleep(25);
        }

        window.deactivate();
    }
}
