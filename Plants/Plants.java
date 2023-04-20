package Plants;

import java.awt.Point;

import javax.swing.ImageIcon;

import Others.Projectile;
import Zombies.Zombies;

public class Plants extends Projectile{
    private int plantDamage;
    private int plantHealth;
    private int xCoordinate;
    private int yCoordinate;
    protected static int plantCount = 0;
    public String name;

    
    public ImageIcon image;
    public int WIDTH;
    public int HEIGHT;
    public ImageIcon cardImage;
    public Point imageCorner;
    public Point imageFirstPoint;
    public Point currentPoint;
    public int check = 0;

    public Plants(int plantDamage,int plantHealth,int x,int y,ImageIcon image,ImageIcon cardImage,String name){
        super(x,y,0,image.getIconWidth(),image.getIconHeight());
        this.plantDamage = plantDamage;
        this.plantHealth = plantHealth;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.image = image;
        this.cardImage = cardImage;
        this.name = name;
        this.imageCorner = new Point(x,y);
        this.imageFirstPoint = new Point(x,y);
        this.currentPoint = new Point(x,y);
        this.WIDTH = cardImage.getIconWidth();
        this.HEIGHT = cardImage.getIconHeight();
        plantCount++;
    }

    public int getDamage(){
        return plantDamage;
    }

    public int getHealth(){
        return plantHealth;
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

    public Point getImageFirstPoint(){
        return imageFirstPoint;
    }

    public String getName(){
        return name;
    }

    public ImageIcon getCardImage(){
        return cardImage;
    }

    public void plantHit(Zombies zombie){
        if (isActive()){
            plantHealth -= zombie.getDamage();
            if (plantHealth <= 0)
                setActive(false);
        }
    }

}
