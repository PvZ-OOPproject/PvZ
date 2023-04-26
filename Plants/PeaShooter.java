package Plants;

import javax.swing.ImageIcon;

public class PeaShooter extends Plants{
    private static int countPeaShooter;
    //public ArrayList<Pea> peaList;
    private Pea pea;
   
    public PeaShooter(int plantDamage, int plantHealth,int x,int y,int xBackyard,int yBackyard) {
        super(plantDamage, plantHealth,x,y,new ImageIcon("pea_shooter.gif"),new ImageIcon("pea_shooter_price.png"),"PeaShooter",100,xBackyard,yBackyard,new ImageIcon("sun_flower_price.png"),250);
        pea = new Pea(plantDamage, x +  3*getImage().getIconWidth()/4, y + getImage().getIconHeight()/4,xBackyard,yBackyard);
        countPeaShooter++;
    }

    public int getCountNormal(){
        return countPeaShooter;
    }

    public Pea getPea(){
        return pea;
    }

}
