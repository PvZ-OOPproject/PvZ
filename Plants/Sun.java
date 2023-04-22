package Plants;

import javax.swing.ImageIcon;

import Others.Projectile;

public class Sun extends Projectile {
    private int yFirstCoordinate;
    private int xCoordinate;
    private int yCoordinate;
    private static ImageIcon image = new ImageIcon("sun.gif");

    public Sun(int x, int y){
        super(x,y,0,image.getIconWidth(),image.getIconHeight());
        this.xCoordinate = x;
        this.yCoordinate = y + 40;
        this.yFirstCoordinate = y + 40;
    }
    
    public void updateSunCard(){
        setXCoordinate(0);
        setYCoordinate(0);
    }

    public ImageIcon getImage(){
        return image;
    }

    public void setXCoordinate(int x){
        this.xCoordinate = x;
    }

    public void setYCoordinate(int y){
        this.yCoordinate = y;
    }

    public int getXCoordinate(){
        return xCoordinate;
    }

    public int getYCoordinate(){
        return yCoordinate;
    }
    
    public int getYFirstCoordinate(){
        return yFirstCoordinate;
    }




}
