package Zombies;

import javax.swing.ImageIcon;

public class Zombie_normal extends Zombies{
    private static int countNormal;
   
    public Zombie_normal(int zombieSpeed, int zombieHealth, int xCoordinate, int yCoordinate) {
        super(zombieSpeed, zombieHealth, xCoordinate, yCoordinate,new ImageIcon("zombie_normal.gif").getImage());
        countNormal++;
    }

    public int getCountNormal(){
        return countNormal;
    }


}
