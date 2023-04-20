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
    public static ArrayList<Pea> peaUpdateList;
    Random random;

    public ObjectDrag(){
        plantsCardList = new ArrayList<Plants>();
        plantsList = new ArrayList<Plants>();
        peaUpdateList = new ArrayList<>();
        random = new Random();
        update();
    }

    public void update(){
        for(int i=1; i < 8;i++){
            //int j = random.nextInt(4);
            int j = 1;
            switch(j){
                case 1:{
                    plantsCardList.add(new PeaShooter(4, 10, 80 + (i-1)*52, 5));
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


    public void drawPlantsCard(GamePanel panel,Graphics g){
        for(Plants i : plantsCardList){
            if (i.check == 0)
                i.cardImage.paintIcon(panel, g ,(int) i.imageCorner.getX(),(int) i.imageCorner.getY());
            else{
                PeaShooter peaShooter = new PeaShooter(4, 200,(int) i.imageCorner.getX(),(int) i.imageCorner.getY());
                Pea pea = new Pea(50,peaShooter.getXCoordinate() , peaShooter.getYCoordinate());
                peaShooter.addPea(pea);
                peaUpdateList.add(pea);
                plantsList.add(peaShooter);
                
                i.currentPoint = new Point((int)i.imageCorner.getX(),(int)i.imageCorner.getY());
                i.imageCorner = new Point((int)i.imageFirstPoint.getX(),(int)i.imageFirstPoint.getY());
                i.check--;
            }

        }

    }

    public void drawPlants(GamePanel panel,Graphics g){
        for(Plants j : plantsList){
            if (j.isActive())
                j.image.paintIcon(panel, g ,(int) j.currentPoint.getX(),(int) j.currentPoint.getY());
        }
    }

    public void updatePeaList(){
        for(Pea i : peaUpdateList){
            i.updatePea();
        }
    }

    public void drawPeaList(GamePanel panel,Graphics g){
        for(Pea i : peaUpdateList){
            if (!i.getStop())
                if (i.isActive())
                    i.getImage().paintIcon(panel,g,i.getX(),(int) i.getY());
        }        
    }
    
    public ArrayList<Pea> getPeaUpdateList(){
        return peaUpdateList;
    }

    public ArrayList<Plants> getPlantsList(){
        return plantsList;
    }



}
