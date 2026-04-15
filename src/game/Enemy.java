package game;

import java.awt.Color;

public class Enemy extends Entity {

    private double xSpeed;
    private double ySpeed;
    private long lastFired;

    public Enemy() {
        super(Math.random() * 0.9, Math.random() * 0.8 + 0.15, 0.03, Color.RED);
        xSpeed = Math.random() * 0.05;
        ySpeed = Math.random() * 0.05;
        lastFired = System.currentTimeMillis();
    }

    public void move() {
        bounceOffWall();
        setXPosition(this.getXPosition() + xSpeed);
        setYPosition(this.getYPosition() + ySpeed);
    }

    private void bounceOffWall() {
        int xMin = 0;
        int xMax = 1;
        double yMin = 0.15;
        int yMax = 1;

        if(this.getXPosition() < xMin || this.getXPosition() > xMax) {
            xSpeed = -xSpeed;
        }
        if(this.getYPosition() > yMax || this.getYPosition() < yMin) {
            ySpeed = -ySpeed;
        }
    }

    public boolean isFiring() {
        long now = System.currentTimeMillis();
        int firingTimeSpent = 1000; 
        if(now - lastFired > firingTimeSpent) {
            lastFired = now;
            return true;
        } else {
            return false;
        }
    }
    
}
