package Others;

import java.awt.*;

import java.util.ArrayList;
import java.util.Random;


import Control.GamePanel;
import Plants.Pea;
import Plants.PeaShooter;
import Plants.Plants;
import Plants.SunFlower;
import Plants.walnut;

public class ObjectDrag {
    public static ArrayList<Plants> plantsCardList;
    public static ArrayList<Plants> plantsList;
    public static ArrayList<Pea> peaUpdateList = new ArrayList<>();
    Random random;

    public ObjectDrag(){
        plantsCardList = new ArrayList<Plants>();
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


    public void addPlantsCard(GamePanel panel,Graphics g){
        for(Plants i : plantsCardList){
            if (i.check == 0)
                i.cardImage.paintIcon(panel, g ,(int) i.imageCorner.getX(),(int) i.imageCorner.getY());
            else{
                //i.cardImage.paintIcon(panel, g ,(int) i.imageFirstPoint.getX(),(int) i.imageFirstPoint.getY());
                //i.image.paintIcon(panel, g ,(int) i.imageCorner.getX(),(int) i.imageCorner.getY());
                PeaShooter peaShooter = new PeaShooter(4, 200,(int) i.imageCorner.getX(),(int) i.imageCorner.getY());
                Pea pea = new Pea(200,peaShooter.getXCoordinate() , peaShooter.getYCoordinate());
                peaShooter.addPea(pea);
                peaUpdateList.add(pea);
                plantsList.add(peaShooter);
                
                i.currentPoint = new Point((int)i.imageCorner.getX(),(int)i.imageCorner.getY());
                i.imageCorner = new Point((int)i.imageFirstPoint.getX(),(int)i.imageFirstPoint.getY());
                i.check--;
            }

        }
        addPlants(panel, g);

    }

    public static void addPlants(GamePanel panel,Graphics g){
        for(Plants j : plantsList){
            j.image.paintIcon(panel, g ,(int) j.currentPoint.getX(),(int) j.currentPoint.getY());
        }
    }

    public void updatePeaList(GamePanel panel,Graphics g){
        for(Pea i : peaUpdateList){
            i.image.paintIcon(panel,g,i.getX(),(int) i.getY());
            i.updatePea();
            //System.out.println(i.getX());
        }
    }
    



}
