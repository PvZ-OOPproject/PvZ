package Zombies;

import java.awt.Image;
import Others.Projectile;
import Plants.Pea;

public class Zombies {
    private int zombieDamage;
    private int zombieSpeed;
    private int zombieHealth;
    private int xCoordinate;
    private int yCoordinate;
    protected static boolean gameOver = false;
    protected static int zombieCount = 0;
    ImageIcon image;

    public Zombies(int zombieSpeed,int zombieHealth,int zombieDamage,int x,int y,ImageIcon image){
        this.zombieSpeed = zombieSpeed;
        this.zombieHealth = zombieHealth;
        this.zombieDamage = zombieDamage;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.image = image;
        zombieCount++;
    }

    public void setZombieSpeed(int x){
        this.zombieSpeed = x;
    }

    public void setZombieHealth(int x){
        this.zombieHealth = x;
    }

    public void setXCoordinate(int x){
        this.xCoordinate += x;
    }

    public void setYCoordinate(int x){
        this.yCoordinate += x;
    }

    public int getXCoordinate(){
        return xCoordinate;
    }

    public int getYCoordinate(){
        return yCoordinate;
    }

    public Image getImage(){
        return image;
    }

    public void zombieHit(){

    }

    public void checkGameOver(){
        
    }


}
