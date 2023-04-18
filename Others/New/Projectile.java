package Others.New;


import java.awt.geom.Rectangle2D;
import static Others.New.Constants.Projectiles.*;

public class Projectile {
    private Rectangle2D.Float hitBox;
    private int dir;
    private boolean active = true;

    public Projectile(int x, int y, int dir){
        hitBox = new Rectangle2D.Float(x,y,PEA_WIDTH,PEA_HEIGHT);
        this.dir = dir;
    }

    public void updatePos(){
        hitBox.x += dir * SPEED;
    }

    public void setPos(int x,int y){
        hitBox.x = x;
        hitBox.y = y;
    }

    public Rectangle2D.Float getHitBox(){
        return hitBox; //to check hit player or not
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public boolean isActive(){
        return active;
    }
}
