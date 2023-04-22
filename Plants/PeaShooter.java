package Plants;

import javax.swing.ImageIcon;

public class PeaShooter extends Plants{
    private static int countPeaShooter;
    //public ArrayList<Pea> peaList;
    private Pea pea;
   
    public PeaShooter(int plantDamage, int plantHealth,int x,int y) {
        super(plantDamage, plantHealth,x,y,new ImageIcon("pea_shooter.gif"),new ImageIcon("pea_shooter_price.png"),"PeaShooter",100);
        //peaList = new ArrayList<Pea>();
        pea = new Pea(plantDamage, x, y);
        countPeaShooter++;
    }

    public int getCountNormal(){
        return countPeaShooter;
    }

    public Pea getPea(){
        return pea;
    }

}
