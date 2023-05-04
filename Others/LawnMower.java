package Others;

import javax.swing.ImageIcon;

public class LawnMower extends Projectile{
    private int xCoordinate;
    private int yCoordinate;
    static ImageIcon image = new ImageIcon("lawn_mower.gif");
    private static final int WIDTH = image.getIconWidth();
    private static final int HEIGHT = image.getIconHeight();

    public LawnMower(int x,int y){
        super(x - WIDTH/2,y - HEIGHT/2,10,WIDTH,HEIGHT);
        this.xCoordinate = x - WIDTH/2;
        this.yCoordinate = y - HEIGHT/2;
    }

    public void updateLawnMower(){
        if(!isActive()){
            if (xCoordinate <= 1000){
                xCoordinate += this.getSpeed();
                this.updatePos();
            }
            else
                this.setPos(0, yCoordinate);

        }
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
