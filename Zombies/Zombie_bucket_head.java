package Zombies;

import javax.swing.ImageIcon;

public class Zombie_bucket_head extends Zombies {
    public Zombie_bucket_head(double zombieSpeed, int zombieHealth, int zombieDamage ,double xCoordinate, double yCoordinate,int xBackyard,int yBackyard) {
        super(zombieSpeed, zombieHealth, zombieDamage ,xCoordinate, yCoordinate,new ImageIcon("zombie_normal.gif"),xBackyard,yBackyard);
    }


}
