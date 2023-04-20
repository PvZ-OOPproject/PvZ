package Plants;

import javax.swing.ImageIcon;

import Others.Projectile;

public class Pea extends Projectile{
    private int damage;
    private int speed;
    private int xCoordinate;
    private int xFirstCoordinate;
    private int delay = 850;
    private int yCoordinate;
    private boolean stop = false;
    public static ImageIcon image = new ImageIcon("Pea.png");
    private static final int WIDTH = image.getIconWidth();
    private static final int HEIGHT = image.getIconHeight();

    public Pea(int damage,int x,int y){
        super(x,y,8,WIDTH,HEIGHT);
        this.damage = damage;
        this.xCoordinate = x;
        this.xFirstCoordinate = x;
        this.yCoordinate = y;
        this.speed = 8;
    }

    public void updatePea() {
        if (!stop){
            if (xCoordinate <= delay + xFirstCoordinate){
                xCoordinate += speed;
                this.updatePos();
                //System.out.println(xCoordinate);
                //System.out.println(this.getHitBox().getX());
            }
            else{
                setX(xFirstCoordinate);
                setPos(xFirstCoordinate, yCoordinate);
                setActive(true);
            }
        }
        else{
            setXFirstCoordinate(-200);
            setActive(false);
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

    public void setY(int y){
        yCoordinate = y;
    }

    public int getDamage(){
        return damage;
    }

    public ImageIcon getImage(){
        return image;
    }

    public int getXFirstCoordinate(){
        return xFirstCoordinate;
    }

    public void setXFirstCoordinate(int x){
        this.xFirstCoordinate = x;
    }

    public void setStop(boolean stop){
        this.stop = stop;
    }

    public boolean getStop(){
        return stop;
    }
}
