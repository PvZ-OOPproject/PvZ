package Zombies;

import javax.swing.ImageIcon;

import Others.Projectile;
import Plants.Pea;

public class Zombies extends Projectile{
    private int zombieDamage;
    private int zombieSpeed;
    private int zombieHealth;
    private int xCoordinate;
    private int yCoordinate;
    private boolean stop = false;
    protected static boolean gameOver = false;
    protected static int zombieCount = 0;
    public ImageIcon image;

    public Zombies(int zombieSpeed,int zombieHealth,int zombieDamage,int x,int y,ImageIcon image){
        super(x,y,zombieSpeed,image.getIconWidth(),image.getIconHeight());
        this.zombieSpeed = zombieSpeed;
        this.zombieHealth = zombieHealth;
        this.zombieDamage = zombieDamage;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.image = image;
        zombieCount++;
    }

    public void updateXCoordinate(){
        if (isActive()){
            if (!stop){
                this.xCoordinate += zombieSpeed;
                this.updatePos();
            }
        }
        else
            {
                xCoordinate = 3000;
                setPos(xCoordinate, yCoordinate);
            }
    }

    public int getXCoordinate(){
        return xCoordinate;
    }

    public int getYCoordinate(){
        return yCoordinate;
    }

    public ImageIcon getImage(){
        return image;
    }

    public int getHealth(){
        return zombieHealth;
    }

    public int getDamage(){
        return zombieDamage;
    }

    public void zombieHit(Pea pea){
        if (isActive()){
            zombieHealth -= pea.getDamage();
            if (zombieHealth <= 0)
                setActive(false);
        }
    }

    public void setStop(boolean stop){
        this.stop = stop;
    }

    public void checkGameOver(){
        
    }


}
