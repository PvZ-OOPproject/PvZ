package Plants;

import javax.swing.ImageIcon;

import Others.Projectile;

public class Pea extends Projectile{
    private int damage;
    private int xFirstCoordinate;
    private int yFirstCoordinate;
    private int delay = 850;
    private boolean shootActive = false;
    private boolean stop = false;
    private boolean prepareStop = false;
    public static ImageIcon image = new ImageIcon("Pea.png");
    private static final int WIDTH = image.getIconWidth();
    private static final int HEIGHT = image.getIconHeight();

    public Pea(int damage,int x,int y,int xBackyard,int yBackyard){
        super(x,y,8,WIDTH,HEIGHT,xBackyard,yBackyard);
        this.damage = damage;
        this.xFirstCoordinate = x;
        this.yFirstCoordinate = y;
    }

    public void updatePea() {
        if (!stop){
            if (isShootActive()){
                if (getXCoordinate() < delay + xFirstCoordinate){
                    setXCoordinate(getXCoordinate() + getSpeed());
                    this.updatePos();
                }
                else{
                    setXCoordinate(xFirstCoordinate);
                    setPos(xFirstCoordinate, getYCoordinate());
                    setImageActive(true);
                }
            }
            else{                
                    if (getXCoordinate() > xFirstCoordinate && getXCoordinate() < delay + xFirstCoordinate){
                        setXCoordinate(getXCoordinate() + getSpeed());
                        this.updatePos();
                    }
                    else{
                        setXCoordinate(xFirstCoordinate);
                        setPos(xFirstCoordinate, getYCoordinate());
                        if (!getPrepareStop())
                            setImageActive(true);
                        else
                            setStop(true);
                    }
            }


        }
        else{
            setXFirstCoordinate(-200);
            setPos(-200, getYCoordinate());
            setImageActive(false);
        }
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

    public void setPrepareStop(boolean active){
        this.prepareStop = active;
    }

    public boolean getPrepareStop(){
        return prepareStop;
    }

}

