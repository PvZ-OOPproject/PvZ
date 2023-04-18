package Plants;

import javax.swing.ImageIcon;

public class Pea {
    private int damage;
    private int speed;
    private int xCoordinate;
    private int yCoordinate;
    public ImageIcon image = new ImageIcon("Pea.png");
    private final int width = image.getIconWidth();
    private final int height = image.getIconHeight();

    public Pea(int damage,int x,int y){
        this.damage = damage;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.speed = 1;
    }

    public void updatePea() {
        if (xCoordinate <= 1200){
            xCoordinate += speed;
        }

    }

    public int getX(){
        return xCoordinate;
    }

    public void setX(int x){
        xCoordinate = x;
    }

    public int getY(){
        return yCoordinate;
    }
}
