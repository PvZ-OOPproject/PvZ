package Plants;

import javax.swing.ImageIcon;

public class PeaShooter extends Plants{
    private static int countPeaShooter;
   
    public PeaShooter(int plantDamage, int plantHealth,int x,int y) {
        super(plantDamage, plantHealth,x,y,new ImageIcon("pea_shooter.gif").getImage());
        countPeaShooter++;
    }

    public int getCountNormal(){
        return countPeaShooter;
    }    
}