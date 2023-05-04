package Plants;

import javax.swing.ImageIcon;

public class DoublePeaShooter extends Plants{
    //public ArrayList<Pea> peaList;
    private Pea pea1;
    private Pea pea2;

   
    public DoublePeaShooter(int plantDamage, int plantHealth,int x,int y,int xBackyard,int yBackyard) {
        super(plantDamage, plantHealth,x,y,new ImageIcon("pea_shooter.gif"),new ImageIcon("pea_shooter_price.png"),"DoublePeaShooter",200,xBackyard,yBackyard,new ImageIcon("sun_flower_price.png"),250);
        pea1 = new Pea(plantDamage, x +  3*getImage().getIconWidth()/4, y + getImage().getIconHeight()/4,xBackyard,yBackyard,new ImageIcon("Pea.png"),"Pea");
        pea2 = new Pea(plantDamage, x +  2*getImage().getIconWidth()/4, y + getImage().getIconHeight()/4,xBackyard,yBackyard,new ImageIcon("Pea.png"),"Pea");
    }

    public Pea getPea1(){
        return pea1;
    }

    public Pea getPea2(){
        return pea2;
    }    

}
