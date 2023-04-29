package Others;

import java.awt.geom.Rectangle2D;

public class Projectile {
    private Rectangle2D.Float hitBox;
    private boolean imageActive = true;
    
    private int speed;
    
    private int xBackyard;
    private int yBackyard;
    private int xCoordinate;
    private int yCoordinate;

    public Projectile(int x, int y,int speed,int width,int height,int xBackyard,int yBackyard){
        hitBox = new Rectangle2D.Float(x,y,width,height);
        this.speed = speed;
        this.xBackyard = xBackyard;
        this.yBackyard = yBackyard;
        this.xCoordinate = x;
        this.yCoordinate = y;
    }
    public void updatePos(){
        hitBox.x += speed;
    }

    public int getSpeed(){
        return speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public void setPos(int x,int y){
        hitBox.x = x;
        hitBox.y = y;
    }

    public Rectangle2D.Float getHitBox(){
        return hitBox;
    }

    public void setImageActive(boolean active){
        this.imageActive = active;
    }

    public boolean isImageActive(){
        return imageActive;
    }
    
    public int getXBackyard(){
        return xBackyard;
    }
    
    public int getYBackyard(){
        return yBackyard;
    }

    public void setXBackyard(int xBackyard){
        this.xBackyard = xBackyard;
    }

    public void setYBackyard(int yBackyard){
        this.yBackyard = yBackyard;
    }

    public int getXCoordinate(){
        return xCoordinate;
    }

    public int getYCoordinate(){
        return yCoordinate;
    }

    public void setXCoordinate(int x){
        this.xCoordinate = x;
    }
}
