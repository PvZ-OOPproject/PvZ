package Plants;

import javax.swing.ImageIcon;

public class Walnut extends Plants{
   
    public Walnut(int plantDamage, int plantHealth,int x,int y,int xBackyard,int yBackyard) {
        super(plantDamage, plantHealth,x,y,new ImageIcon("walnut_full_life.gif"),new ImageIcon("walnut_price.png"),"Walnut",50,xBackyard,yBackyard,new ImageIcon("walnut_full_life.gif"),250);
    }

}
