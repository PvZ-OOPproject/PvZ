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
        for(int i=0; i < 3;i++){
            //int j = random.nextInt(4);
            int j = 1;
            switch(j){
                case 1:{
                    plantsList.add(new PeaShooter(4, 200, random.nextInt(200), 20));
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
