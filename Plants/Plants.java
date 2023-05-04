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
    private int plantsValue;
   
    private int xBackyard;
    private int yBackyard;

    public ImageIcon image;
    public int WIDTH;
    public int HEIGHT;
    public ImageIcon cardImage;
    public Point imageCorner;
    public Point imageFirstPoint;
    public Point currentPoint;
    public int check = 0;

    public Plants(int plantDamage,int plantHealth,int x,int y,ImageIcon image,ImageIcon cardImage,String name,int plantsValue,int xBackyard,int yBackyard){
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
        this.WIDTH = image.getIconWidth();
        this.HEIGHT = image.getIconHeight();
        this.plantsValue = plantsValue;
        plantCount++;
        this.xBackyard = xBackyard;
        this.yBackyard = yBackyard;
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

    public void setXCoordinate(int x){
        this.xCoordinate = x;
    }

    public void setYCoordinate(int y){
        this.yCoordinate = y;
    }

    public int getYCoordinate(){
        return yCoordinate;
    }

    public ImageIcon getImage(){
        return image;
    }

    public int getPlantsValue(){
        return plantsValue;
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

    public int getXBackyard(){
        return xBackyard;
    }

    public int getYBackyard(){
        return yBackyard;
    }

    public void plantHit(Zombies zombie){
        if (isActive()){
            plantHealth -= zombie.getDamage();
        }
    }



}
