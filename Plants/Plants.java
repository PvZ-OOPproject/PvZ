package Plants;

import java.awt.Image;
import java.awt.Point;

import Others.ObjectDrag;

public class Plants extends ObjectDrag{
    private int plantDamage;
    private int plantHealth;
    private int xCoordinate;
    private int yCoordinate;
    protected static int plantCount = 0;
    Image image;
    public Point prePt = new Point(xCoordinate,yCoordinate);
    public Point currentPt;

    public Plants(int plantDamage,int plantHealth,int x,int y,Image image){
        super(x,y,image);
        this.plantDamage = plantDamage;
        this.plantHealth = plantHealth;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.image = image;
        plantCount++;
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
}
