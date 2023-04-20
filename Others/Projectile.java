package Others;

import java.awt.geom.Rectangle2D;

public class Projectile {
    private Rectangle2D.Float hitBox;
    private boolean active = true;
    private int speed;

    public Projectile(int x, int y,int speed,int width,int height){
        hitBox = new Rectangle2D.Float(x,y,width,height);
        this.speed = speed;
    }
    public void updatePos(){
        hitBox.x += speed;
    }

    public void setPos(int x,int y){
        hitBox.x = x;
        hitBox.y = y;
    }

    public Rectangle2D.Float getHitBox(){
        return hitBox;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public boolean isActive(){
        return active;
    }
    
    public void checkHit(){
        
    }
}
