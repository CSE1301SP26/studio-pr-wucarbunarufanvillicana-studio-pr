package game;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class Player extends Entity {

    private long lastFired;
    private double movementSize; 

    public Player() {
        super(0.5, 0.05, 0.03, Color.BLACK);
        lastFired = System.currentTimeMillis();
        this.movementSize = 0.01; 
    }

    public void move() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
            setXPosition(this.getXPosition() - this.movementSize);
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
            setXPosition(this.getXPosition() + this.movementSize);
        }
    }

    public boolean isFiring() {
        long now = System.currentTimeMillis();
        int timeSpent = 500; 
        if (now - lastFired > timeSpent && StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
            lastFired = now;
            return true; 
        }
        else {
            return false; 
        }
}
}
