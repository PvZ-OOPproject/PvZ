package Plants;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class SunFlower extends Plants{
    private static int countSunFlower;
    private int delay = 0;
    private int count = 0;
   
    public SunFlower(int plantDamage, int plantHealth,int x,int y) {
        super(plantDamage, plantHealth,x,y,new ImageIcon("sun_flower.gif"),new ImageIcon("sun_flower.gif"),"SunFlower",50);
        countSunFlower++;
    }

    public int getCountNormal(){
        return countSunFlower;
    }

    public void updateSun(ArrayList<Sun> sunList){
        if (isActive()){
            if (delay <= 400){
                delay += 2;
            }
            else{
                delay = 0;
                this.setXCoordinate(this.getXCoordinate()+count);
                sunList.add(new Sun(this.getXCoordinate(),this.getYCoordinate()));
                this.setXCoordinate(this.getXCoordinate()-count);
                if (count < 20)
                    count += 10;
                else
                    count = 0;
                //System.out.println(sunList.size());
                //System.out.println(sunList.size());
            }
        }
    }

}
