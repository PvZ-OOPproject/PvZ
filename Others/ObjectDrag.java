package Others;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;


import Control.GamePanel;
import Plants.Pea;
import Plants.PeaShooter;
import Plants.Plants;
import Plants.Sun;
import Plants.SunFlower;
import Plants.walnut;

public class ObjectDrag {
    public static ArrayList<Plants> plantsCardList;
    public static ArrayList<Plants> plantsList;
    public static ArrayList<Pea> peaUpdateList;
    public static ArrayList<SunFlower> sunFlowerList;
    public static ArrayList<Sun> sunUpdateList;
    public static ArrayList<Sun> sunFallingUpdateList;
    public static int sunValue = 100;
    private int delaySunFalling = 400;
    Shovel shovel;
    Random random;

    public ObjectDrag(){
        plantsCardList = new ArrayList<Plants>();
        plantsList = new ArrayList<Plants>();
        peaUpdateList = new ArrayList<>();
        sunFlowerList = new ArrayList<>();
        sunUpdateList = new ArrayList<>();
        sunFallingUpdateList = new ArrayList<>();
        random = new Random();
        shovel = new Shovel(460, 5);
        update();
    }

    public void update(){
        for(int i=1; i < 3;i++){
            //int j = random.nextInt(4);
            //int j = 2;
            switch(i){
                case 1:{
                    plantsCardList.add(new PeaShooter(4, 200, 80 + (i-1)*52, 5));
                    break; 
                }
                case 2:{
                    plantsCardList.add(new SunFlower(0, 200, 80 + (i-1)*52, 5));
                    break;                     
                }
                case 3:{
                    plantsCardList.add(new walnut(500, 200, 100+random.nextInt(200), 100));
                    break;                     
                }                
            }
        }
    }

    public void updateSunFalling(){
        if (delaySunFalling < 400)
            delaySunFalling += 1;
        else{
            int x = 290 + random.nextInt(80*8 + 1);
            int y = -450 -40 + random.nextInt(4*100 + 1);
            sunFallingUpdateList.add(new Sun(x,y));
            delaySunFalling = 0;
        }
        for(Sun i : sunFallingUpdateList){
            if (i.isActive())
                if (i.getYCoordinate() <= i.getYFirstCoordinate() + 580)
                    i.setYCoordinate(i.getYCoordinate() + 2);
        }
    }
    
    public void drawSunFalling(GamePanel panel,Graphics g){
        for(Sun i : sunFallingUpdateList){
            i.getImage().paintIcon(panel, g, i.getXCoordinate(), i.getYCoordinate());
        }
    }

    public void drawPlantsCard(GamePanel panel,Graphics g){
        for(Plants i : plantsCardList){
            if (i.check == 0)
                i.cardImage.paintIcon(panel, g ,(int) i.imageCorner.getX(),(int) i.imageCorner.getY());
            else{
                if (i.getName().equals("PeaShooter")){
                    PeaShooter peaShooter = new PeaShooter(50, 200,(int) i.imageCorner.getX(),(int) i.imageCorner.getY());
                    //Pea pea = new Pea(50,peaShooter.getXCoordinate() , peaShooter.getYCoordinate());
                    //peaShooter.addPea(pea);
                    peaUpdateList.add(peaShooter.getPea());
                    plantsList.add(peaShooter);
                }
                else if (i.getName().equals("SunFlower")){
                    SunFlower sunFlower = new SunFlower(0, 200, (int) i.imageCorner.getX(),(int) i.imageCorner.getY());
                    plantsList.add(sunFlower);
                    sunFlowerList.add(sunFlower);
                }
                i.currentPoint = new Point((int)i.imageCorner.getX(),(int)i.imageCorner.getY());
                i.imageCorner = new Point((int)i.imageFirstPoint.getX(),(int)i.imageFirstPoint.getY());
                i.check--;
            }

        }

    }

    public void drawShovel(GamePanel panel,Graphics g){
        shovel.getImage().paintIcon(panel, g, shovel.getXCoordinate(),shovel.getYCoordinate());
    }

    public void drawPlants(GamePanel panel,Graphics g){
        for(Plants j : plantsList){
            if (j.isActive())
                j.image.paintIcon(panel, g ,(int) j.currentPoint.getX(),(int) j.currentPoint.getY());
        }
    }

    public void drawPeaList(GamePanel panel,Graphics g){
        for(Pea i : peaUpdateList){
            if (!i.getStop())
                if (i.isActive())
                    i.getImage().paintIcon(panel,g,i.getX(),(int) i.getY());
        }        
    }

    public void updatePeaList(){
        for(Pea i : peaUpdateList){
            i.updatePea();
        }
    }

    public void updateSunList(){
        for(SunFlower i : sunFlowerList){
            i.updateSun(sunUpdateList);   
        }
    }

    public void updateSunCard(MouseEvent e,ArrayList<Sun> sunList){
        for(Sun i : sunList){
            if (i.getYCoordinate() >= 80)
                if (Math.abs((int) i.getXCoordinate()-e.getPoint().getX()) <= i.getImage().getIconWidth() && Math.abs((int) i.getYCoordinate()-e.getPoint().getY()) <= i.getImage().getIconHeight()){
                    i.setXCoordinate(0);
                    i.setYCoordinate(0);
                    sunValue += 50;
                    i.setActive(false);
                    break;
                }
        }
    }

    public void updateSunValue(int plantsValue){
        sunValue -= plantsValue;
    }
    
    public void drawSun(GamePanel panel,Graphics g){
        for(Sun i : sunUpdateList){
            i.getImage().paintIcon(panel, g, i.getXCoordinate(), i.getYCoordinate());
        }
    }
    
    public ArrayList<Pea> getPeaUpdateList(){
        return peaUpdateList;
    }

    public ArrayList<Plants> getPlantsList(){
        return plantsList;
    }

    public ArrayList<Plants> getPlantsCardList(){
        return plantsCardList;
    }

    public ArrayList<Sun> getSunList(){
        return sunUpdateList;
    }

    public ArrayList<Sun> getSunFallingList(){
        return sunFallingUpdateList;
    }

    public int getSunValue(){
        return sunValue;
    }



}
