package Plants;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class PeaShooter extends Plants{
    private static int countPeaShooter;
    public ArrayList<Pea> peaList;
   
    public PeaShooter(int plantDamage, int plantHealth,int x,int y) {
        super(plantDamage, plantHealth,x,y,new ImageIcon("pea_shooter.gif"),new ImageIcon("pea_shooter_price.png"),"PeaShooter");
        peaList = new ArrayList<Pea>();
        countPeaShooter++;
    }

    public int getCountNormal(){
        return countPeaShooter;
    }

    public void addPea(Pea pea){
        peaList.add(pea);
    }

}
