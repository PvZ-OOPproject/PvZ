package Others;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class Shovel {
    private int xCoordinate;
    private int yCoordinate;
    private boolean imageActive = true;
    private Point imageFirstPoint;
    private Point imageCorner;
    

    ImageIcon image = new ImageIcon("shovel.png");

    public Shovel(int x,int y){
        this.xCoordinate = x;
        this.yCoordinate = y;
        imageCorner = new Point(x,y);
        imageFirstPoint = new Point(x, y);
    }

    public ImageIcon getImage(){
        return image;
    }

    public int getXCoordinate(){
        return xCoordinate;
    }

    public int getYCoordinate(){
        return yCoordinate;
    }

    public boolean isImageActive(){
        return imageActive;
    }

    public void setImageActive(boolean active){
        this.imageActive = active;
    }

    public Point getImageFirstPoint(){
        return imageFirstPoint;
    }

    public Point getImageCorner(){
        return imageCorner;
    }

    public void setImageCorner(Point point){
        this.imageCorner = point;
    }

    public boolean checkShovel(MouseEvent e){
        if (e.getX() >= imageFirstPoint.getX() && e.getX() <= imageFirstPoint.getX() + image.getIconWidth()){
            if (e.getY() >= imageFirstPoint.getY() && e.getY() <= imageFirstPoint.getY() + image.getIconHeight()){
                return true;
            }
        }
        return false;
    }
}
