package Others;

import java.awt.*;

import java.util.ArrayList;
import java.util.Random;


import Control.GamePanel;
import Plants.PeaShooter;
import Plants.Plants;
import Plants.SunFlower;
import Plants.walnut;

public class ObjectDrag {
    public static ArrayList<Plants> plantsCardList;
    Random random;

    public ObjectDrag(){
        plantsCardList = new ArrayList<Plants>();
        random = new Random();
        update();
    }

    public void update(){
        for(int i=1; i < 8;i++){
            //int j = random.nextInt(4);
            int j = 1;
            switch(j){
                case 1:{
                    plantsCardList.add(new PeaShooter(4, 200, 80 + (i-1)*52, 5));
                    break; 
                }
                case 2:{
                    plantsCardList.add(new SunFlower(50, 200, 100+random.nextInt(200), 100));
                    break;                     
                }
                case 3:{
                    plantsCardList.add(new walnut(500, 200, 100+random.nextInt(200), 100));
                    break;                     
                }                
            }
        }
    }

    public void addPlantsCard(GamePanel panel,Graphics g){
        for(Plants i : plantsCardList){
            i.cardImage.paintIcon(panel, g ,(int) i.imageCorner.getX(),(int) i.imageCorner.getY());
        }
    }

    public void addPlants(GamePanel panel,Graphics g){
        for(Plants i : plantsCardList){
            
            //image.paintIcon(panel, g,i.getXCoordinate(), i.getYCoordinate());
        }
    }
    

}
