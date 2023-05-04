package Plants;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class SunFlower extends Plants{
    private static int countSunFlower;
    private int delay = 0;
    private int count = 0;
   
    public SunFlower(int plantDamage, int plantHealth,int x,int y,int xBackyard,int yBackyard) {
        super(plantDamage, plantHealth,x,y,new ImageIcon("sun_flower.gif"),new ImageIcon("sun_flower_price.png"),"SunFlower",50,xBackyard,yBackyard,new ImageIcon("sun_flower_price.png"),250);

        countSunFlower++;
    }

    public int getCountNormal(){
        return countSunFlower;
    }

    public void updateSun(ArrayList<Sun> sunList){
        if (isImageActive()){
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
            }
        }
    }

}
