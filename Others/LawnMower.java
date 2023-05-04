package Others;

import javax.swing.ImageIcon;

public class LawnMower extends Projectile{
    static ImageIcon image = new ImageIcon("lawn_mower.gif");
    private static final int WIDTH = image.getIconWidth();
    private static final int HEIGHT = image.getIconHeight();


    public LawnMower(int x,int y,int xBackyard,int yBackyard){
        super(x - WIDTH/2,y - HEIGHT/2,10,WIDTH,HEIGHT,xBackyard,yBackyard);
    }

    public void updateLawnMower(){
        if(!isImageActive()){
            if (getXCoordinate() <= 1000){
                setXCoordinate(getXCoordinate() + getSpeed());
                updatePos();
            }
            else
                setPos(0, getYCoordinate());


        }
    }

    public ImageIcon getImage(){
        return image;
    }


}
