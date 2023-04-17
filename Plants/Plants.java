package Plants;

import java.awt.Point;

import javax.swing.ImageIcon;

public class Plants {
    private int plantDamage;
    private int plantHealth;
    private int xCoordinate;
    private int yCoordinate;
    protected static int plantCount = 0;
    
    public ImageIcon image;
    public int WIDTH;
    public int HEIGHT;
    public ImageIcon cardImage;
    public Point imageCorner;
    public Point imageFirstPoint;

    public Plants(int plantDamage,int plantHealth,int x,int y,ImageIcon image,ImageIcon cardImage){
        this.plantDamage = plantDamage;
        this.plantHealth = plantHealth;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.image = image;
        this.cardImage = cardImage;
        this.imageCorner = new Point(x,y);
        this.imageFirstPoint = new Point(x,y);
        this.WIDTH = cardImage.getIconWidth();
        this.HEIGHT = cardImage.getIconHeight();
        plantCount++;
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

}
