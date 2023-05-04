package Plants;

import java.awt.Point;

import javax.swing.ImageIcon;

import Others.Projectile;

public class Plants extends Projectile{
    private int plantDamage;
    private int plantHealth;
    protected static int plantCount = 0;
    public String name;
    private int plantsValue;
   

    private boolean checkDelay = false;
    private int constDelay;
    private int delay = 0;
    private ImageIcon imageDelay;


    public ImageIcon image;
    public int WIDTH;
    public int HEIGHT;
    public ImageIcon cardImage;
    private Point imageCorner;
    public Point imageFirstPoint;
    public Point currentPoint;
    public int check = 0;


    public Plants(int plantDamage,int plantHealth,int x,int y,ImageIcon image,ImageIcon cardImage,String name,int plantsValue,int xBackyard,int yBackyard,ImageIcon imageDelay,int constDelay){
        super(x,y,0,image.getIconWidth(),image.getIconHeight(),xBackyard,yBackyard);
        this.plantDamage = plantDamage;
        this.plantHealth = plantHealth;
        this.image = image;
        this.cardImage = cardImage;
        this.name = name;
        this.imageCorner = new Point(x,y);
        this.imageFirstPoint = new Point(x,y);
        this.currentPoint = new Point(x,y);

        this.plantsValue = plantsValue;
        this.imageDelay = imageDelay;
        this.constDelay = constDelay;
    }

    public int getDamage(){
        return plantDamage;
    }

    public int getHealth(){
        return plantHealth;
    }

    public ImageIcon getImage(){
        return image;
    }

    public int getPlantsValue(){
        return plantsValue;
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

    public String getName(){
        return name;
    }

    public ImageIcon getCardImage(){
        return cardImage;
    }

    public void plantHit(int damage){
        if (isImageActive()){
            plantHealth -= damage;
        }
    }

    public ImageIcon getImageDelay(){
        return imageDelay;
    }

    public int getConstDelay(){
        return constDelay;
    }

    public void setConstDelay(int delay){
        this.constDelay = delay;
    }

    public int getDelay(){
        return delay;
    }

    public void setDelay(int delay){
        this.delay = delay;
    }

    public boolean getCheckDelay(){
        return checkDelay;
    }

    public void setCheckDelay(boolean active){
        this.checkDelay = active;
    }
}
