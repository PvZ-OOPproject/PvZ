package Plants;

import javax.swing.ImageIcon;

public class walnut extends Plants{
    private static int countSunFlower;
   
    public walnut(int plantDamage, int plantHealth,int x,int y) {
        super(plantDamage, plantHealth,x,y,new ImageIcon("walnut_full_life.gif"),new ImageIcon("walnut_full_life.gif"),"Walnut");
        countSunFlower++;
    }

    public int getCountNormal(){
        return countSunFlower;
    }      
}
