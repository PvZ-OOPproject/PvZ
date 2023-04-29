package Plants;

import javax.swing.ImageIcon;

public class IcePeaShooter extends Plants{
    //public ArrayList<Pea> peaList;
    private Pea pea;
   
    public IcePeaShooter(int plantDamage, int plantHealth,int x,int y,int xBackyard,int yBackyard) {
        super(plantDamage, plantHealth,x,y,new ImageIcon("pea_shooter.gif"),new ImageIcon("ice_pea_shooter_price.png"),"IcePeaShooter",175,xBackyard,yBackyard,new ImageIcon("sun_flower_price.png"),250);
        pea = new Pea(plantDamage, x +  3*getImage().getIconWidth()/4, y + getImage().getIconHeight()/4,xBackyard,yBackyard,new ImageIcon("Pea.png"),"IcePea");
    }

    public Pea getPea(){
        return pea;
    }



}

