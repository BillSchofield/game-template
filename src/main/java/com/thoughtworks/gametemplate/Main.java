package com.thoughtworks.gametemplate;


import com.thoughtworks.gametemplate.game.entities.Vector2f;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Vector2f gameSize = new Vector2f(800, 600);

        Application application = new Application(gameSize);
        application.start();
    }
}
