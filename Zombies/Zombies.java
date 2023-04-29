package Zombies;

import javax.swing.ImageIcon;

import Others.Projectile;

public class Zombies extends Projectile{
    private int zombieDamage;
    private int zombieHealth;
    private int zombieFirstSpeed;
    private int effectedZombieDelay = 0;

    private int zombieFirstHealth;

    private int check = 0;

    private boolean stopMotion = false;
    protected static boolean gameOver = false;
    public ImageIcon image;

    public Zombies(int zombieSpeed,int zombieHealth,int zombieDamage,int x,int y,ImageIcon image,int xBackyard,int yBackyard){
        super(x,y,zombieSpeed,image.getIconWidth(),image.getIconHeight(),xBackyard,yBackyard);
        this.zombieHealth = zombieHealth;
        this.zombieDamage = zombieDamage;
        this.image = image;
        this.zombieFirstHealth = zombieHealth;
        this.zombieFirstSpeed = zombieSpeed;
    }

    public void updateXCoordinate(){
        effectedZombieDelay++;
        if (effectedZombieDelay == 400){
            setEffectedZombieDelay(0);
            setSpeed(zombieFirstSpeed);
        }

        if (isImageActive()){
            if (!stopMotion){
                setXCoordinate(getXCoordinate() + getSpeed());
                this.updatePos();
            }
        }
        else
            {
                setXCoordinate(3000);
                setPos(getXCoordinate(), getYCoordinate());
            }
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

    public void zombieHit(int damage){
        if (isImageActive()){
            zombieHealth -= damage;
        }
    }

    public void setStopMotion(boolean stop){
        this.stopMotion = stop;
    }

    public boolean checkGameOver(){
        if (getXCoordinate() <= 150)
            return true;
        return false;
    }

    public int getCheck(){
        return check;
    }

    public void setCheck(int check){
        this.check = check;
    }

    public int getFirstHealth(){
        return zombieFirstHealth;
    }

    public void setHealth(int health){
        this.zombieHealth = health;
    }

    public int getFirstSpeed(){
        return zombieFirstSpeed;
    }

    public int getEffectedZombieDelay(){
        return effectedZombieDelay;
    }

    public void setEffectedZombieDelay(int delay){
        this.effectedZombieDelay = delay;
    }    
}
