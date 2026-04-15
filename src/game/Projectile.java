package game;

import java.awt.Color;

public class Projectile extends Entity {

    
    public Projectile(double x, double y, Color color) {
        super(x, y, 0.01 , color);
        
    }

    public void moveUp() {
        setYPosition(this.getYPosition() + 0.01);
    }

    public void moveDown() {
        setYPosition(this.getYPosition() - 0.01);
    }

    public boolean isOutOfBounds() {
        return this.getYPosition() > 1 || this.getYPosition() < 0;
    }

}
