package Zombies;

import javax.swing.ImageIcon;

public class Zombie_normal extends Zombies{
   
    public Zombie_normal(double zombieSpeed, int zombieHealth, int zombieDamage ,double xCoordinate, double yCoordinate,int xBackyard,int yBackyard) {
        super(zombieSpeed, zombieHealth, zombieDamage ,xCoordinate, yCoordinate,new ImageIcon("zombie_normal.gif"),xBackyard,yBackyard);
    }



}

