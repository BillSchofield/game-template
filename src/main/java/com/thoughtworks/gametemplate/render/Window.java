package com.thoughtworks.gametemplate.render;

import com.thoughtworks.gametemplate.game.Vector2f;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Graphics;

public class Window extends JFrame {
    public static final int exitOnClose = WindowConstants.EXIT_ON_CLOSE;
    private Renderer renderer;
    private Vector2f size;

    public Window(Renderer renderer, Vector2f size) {
        this.renderer = renderer;
        this.size = size;
    }


    @Override
    public void paint(Graphics graphics) {
        renderer.draw(graphics);
    }

    @Override
    public void update(Graphics graphics) {
        paint(graphics);
    }

    public void activate() {
        setSize(size.getX(), size.getY());
        setLocation(0, 0);
        setVisible(true);
        setDefaultCloseOperation(exitOnClose);
    }


    public void deactivate() {
        dispose();
    }
}
