package Plants;

import javax.swing.ImageIcon;

import Others.Projectile;

public class Pea extends Projectile{
    private int damage;
    private int speed;
    private int xCoordinate;
    private int xFirstCoordinate;
    private int yFirstCoordinate;
    private int delay = 850;
    private int yCoordinate;
    private boolean shootActive = false;
    private boolean stop = false;
    public static ImageIcon image = new ImageIcon("Pea.png");
    private static final int WIDTH = image.getIconWidth();
    private static final int HEIGHT = image.getIconHeight();

    private int xBackyard;
    private int yBackyard;    

    public Pea(int damage,int x,int y,int xBackyard,int yBackyard){
        super(x,y,8,WIDTH,HEIGHT);
        this.damage = damage;
        this.xCoordinate = x;
        this.xFirstCoordinate = x;
        this.yFirstCoordinate = y;
        this.yCoordinate = y;
        this.speed = 8;
        this.xBackyard = xBackyard;
        this.yBackyard = yBackyard;
    }

    public void updatePea() {
        if (!stop){
            if (isShootActive()){
                if (xCoordinate < delay + xFirstCoordinate){
                    xCoordinate += speed;
                    this.updatePos();
                }
                else{
                    setX(xFirstCoordinate);
                    setPos(xFirstCoordinate, yCoordinate);
                    setActive(true);
                }
            }
            else{
                    if (xCoordinate > xFirstCoordinate && xCoordinate < delay + xFirstCoordinate){
                        xCoordinate += speed;
                        this.updatePos();
                    }
                    else{
                        setX(xFirstCoordinate);
                        setPos(xFirstCoordinate, yCoordinate);
                        setActive(true);
                    }
            }


        }
        else{
            setXFirstCoordinate(-200);
            setPos(-200, yCoordinate);
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

    public int getYFirstCoordinate(){
        return yFirstCoordinate;
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

    public boolean isShootActive(){
        return shootActive;
    }

    public void setShootActive(boolean active){
        this.shootActive = active;
    }

    public int getYBackyard(){
        return yBackyard;
    }
}

