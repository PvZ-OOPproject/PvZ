package Others;

import javax.swing.ImageIcon;

public class Shovel {
    private int xCoordinate;
    private int yCoordinate;
    ImageIcon image = new ImageIcon("shovel.png");

    public Shovel(int x,int y){
        this.xCoordinate = x;
        this.yCoordinate = y;
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

}
