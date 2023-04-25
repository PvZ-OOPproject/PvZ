package Plants;

import javax.swing.ImageIcon;

public class PeaShooter extends Plants{
    private static int countPeaShooter;
    //public ArrayList<Pea> peaList;
    private Pea pea;
   
    public PeaShooter(int plantDamage, int plantHealth,int x,int y,int xBackyard,int yBackyard) {
        super(plantDamage, plantHealth,x,y,new ImageIcon("pea_shooter.gif"),new ImageIcon("pea_shooter_price.png"),"PeaShooter",100,xBackyard,yBackyard);
        //peaList = new ArrayList<Pea>();
        ImageIcon image = new ImageIcon("pea_shooter_price.png");
        pea = new Pea(plantDamage, x, y,x + image.getIconWidth()/2,y + image.getIconHeight());
        countPeaShooter++;
    }

    public int getCountNormal(){
        return countPeaShooter;
    }

    public Pea getPea(){
        return pea;
    }

}
