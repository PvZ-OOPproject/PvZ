package Plants;

import javax.swing.ImageIcon;

public class SunFlower extends Plants{
    private static int countSunFlower;
   
    public SunFlower(int plantDamage, int plantHealth,int x,int y) {
        super(plantDamage, plantHealth,x,y,new ImageIcon("sun_flower.gif"),new ImageIcon("sun_flower.gif"),"SunFlower");
        countSunFlower++;
    }

    public int getCountNormal(){
        return countSunFlower;
    }      

}
