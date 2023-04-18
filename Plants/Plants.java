package Plants;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Control.GamePanel;

public class Plants {
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

    public int getXCoordinate(){
        return xCoordinate;
    }

    public int getYCoordinate(){
        return yCoordinate;
    }

    public ImageIcon getImage(){
        return image;
    }

    public ImageIcon getCardImage(){
        return cardImage;
    }

    public void drawPea(GamePanel panel,Graphics g){}

    public void addPea(int i) {
    }
}
