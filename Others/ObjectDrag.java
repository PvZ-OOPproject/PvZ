package Others;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import Plants.PeaShooter;
import Plants.Plants;

public class ObjectDrag {
    Image image;
    Point imageCorner;
    Point prePt;
    public static ArrayList<Plants> plantsList;
    Random random;

    public ObjectDrag(int x,int y,Image image){
        imageCorner = new Point(x,y);
        this.image = image;
        plantsList = new ArrayList<Plants>();
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

    public void addPlants(Graphics2D g2D,int x){
        for(Plants i : plantsList){
            g2D.drawImage(i.getImage(), x, i.getYCoordinate(), null);
        }
    }

}
