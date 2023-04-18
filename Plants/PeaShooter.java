package Plants;

import java.awt.Graphics;
import java.util.ArrayList;


import javax.swing.ImageIcon;

import Control.GamePanel;


public class PeaShooter extends Plants{
    private static int countPeaShooter;
    public static ArrayList<Pea> peaList;
   
    public PeaShooter(int plantDamage, int plantHealth,int x,int y) {
        super(plantDamage, plantHealth,x,y,new ImageIcon("pea_shooter.gif"),new ImageIcon("pea_shooter_price.png"),"PeaShooter");
        peaList = new ArrayList<Pea>();
        countPeaShooter++;
    }

    public int getCountNormal(){
        return countPeaShooter;
    }

    public void addPea(Pea pea){
        peaList.add(pea);
    }

    public void drawPea(GamePanel panel,Graphics g){
        for(Pea i : peaList){
            //i.setX((int) this.currentPoint.getX());
            i.image.paintIcon(panel,g,i.getX(),(int) this.currentPoint.getY());
        }
    }


}
