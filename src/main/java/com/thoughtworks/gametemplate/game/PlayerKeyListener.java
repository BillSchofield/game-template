package com.thoughtworks.gametemplate.game;

import com.thoughtworks.gametemplate.game.entities.Vector2f;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class PlayerKeyListener implements KeyListener {
    private Map<Character, Boolean> keyStatus = new HashMap<>();
    private final static Vector2f left = new Vector2f(-10, 0);
    private final static Vector2f right = new Vector2f(10, 0);

    @Override
    public void keyTyped(KeyEvent event) {
    }

    @Override
    public void keyPressed(KeyEvent event) {
        Character pressedKey = event.getKeyChar();
        keyStatus.put(pressedKey, true);
    }

    @Override
    public void keyReleased(KeyEvent event) {
        Character pressedKey = event.getKeyChar();
        keyStatus.put(pressedKey, false);
    }

    public Vector2f desiredMove() {
        if (firstKeyIsDownAndOtherKeyIsNot('a', 'd')){
            return left;
        }
        if (firstKeyIsDownAndOtherKeyIsNot('d', 'a')){
            return right;
        }
        return  Vector2f.Zero;
    }

    private boolean firstKeyIsDownAndOtherKeyIsNot(char firstKey, char secondKey) {
        boolean firstKeyIsDown = keyIsDown(firstKey);
        boolean secondKeyIsDown = keyIsDown(secondKey);
        return firstKeyIsDown && !secondKeyIsDown;
    }

    private boolean keyIsDown(char key) {
        return keyStatus.containsKey(key) && keyStatus.get(key);
    }

    public boolean shouldFire() {
        return keyIsDown(' ');
    }
}
