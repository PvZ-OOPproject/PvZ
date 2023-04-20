package Zombies;

import javax.swing.ImageIcon;

public class Zombie_normal extends Zombies{
    private static int countNormal;
    public static ImageIcon image = new ImageIcon("zombie_normal.gif");
   
    public Zombie_normal(int zombieSpeed, int zombieHealth, int xCoordinate, int yCoordinate) {
        super(zombieSpeed, zombieHealth, 1 ,xCoordinate, yCoordinate,image);
        countNormal++;
    }

    public int getCountNormal(){
        return countNormal;
    }


}

