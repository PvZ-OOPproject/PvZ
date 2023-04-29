package Others;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;


import Control.GamePanel;
import Plants.DoublePeaShooter;
import Plants.IcePeaShooter;
import Plants.Pea;
import Plants.PeaShooter;
import Plants.Plants;
import Plants.Sun;
import Plants.SunFlower;
import Plants.Walnut;

public class ObjectDrag {
    public static ArrayList<Plants> plantsCardList;
    public static ArrayList<Plants> plantsList;
    public static ArrayList<Pea> peaUpdateList;
    public static ArrayList<SunFlower> sunFlowerList;
    public static ArrayList<Sun> sunUpdateList;
    public static ArrayList<Sun> sunFallingUpdateList;
    private int sunValue = 300;
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
        for(int i=1; i <= 5;i++){
            //int j = random.nextInt(4);
            //int j = 2;
            switch(i){
                case 1:{
                    plantsCardList.add(new PeaShooter(4, 200, 80 + (i-1)*52, 5,40,80 + 26 + (i-1)*52));
                    break; 
                }
                case 2:{
                    plantsCardList.add(new SunFlower(0, 200, 80 + (i-1)*52, 5,40,80 + 26 + (i-1)*52));
                    break;                     
                }
                case 3:{
                    plantsCardList.add(new Walnut(500, 200, 80 + (i-1)*52, 5,40,80 + 26 + (i-1)*52));
                    break;                     
                }
                case 4:{
                    plantsCardList.add(new DoublePeaShooter(4, 200, 80 + (i-1)*52, 5,40,80 + 26 + (i-1)*52));
                    break;                    
                }
                case 5:{
                    plantsCardList.add(new IcePeaShooter(4, 200, 80 + (i-1)*52, 5,40,80 + 26 + (i-1)*52));
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
            if (i.isImageActive())
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
                if (!i.getCheckDelay())
                    i.cardImage.paintIcon(panel, g ,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY());
                else{
                    i.getImageDelay().paintIcon(panel, g ,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY());
                    i.setDelay(i.getDelay()+1);
                    if (i.getDelay() == i.getConstDelay()){
                        i.setCheckDelay(false);
                        i.setDelay(0);
                    }
                }
            else{
                if (i.getName().equals("PeaShooter")){
                    PeaShooter peaShooter = new PeaShooter(50, 200,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getXBackyard(),i.getYBackyard());
                    peaUpdateList.add(peaShooter.getPea());
                    plantsList.add(peaShooter);
                }
                else if (i.getName().equals("SunFlower")){
                    SunFlower sunFlower = new SunFlower(0, 200, (int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getXBackyard(),i.getYBackyard());
                    plantsList.add(sunFlower);
                    sunFlowerList.add(sunFlower);
                }
                else if (i.getName().equals("DoublePeaShooter")){
                    DoublePeaShooter doublePeaShooter = new DoublePeaShooter(50, 200,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getXBackyard(),i.getYBackyard());
                    peaUpdateList.add(doublePeaShooter.getPea1());
                    peaUpdateList.add(doublePeaShooter.getPea2());
                    plantsList.add(doublePeaShooter);
                }
                else if (i.getName().equals("Walnut")){
                    Walnut walnut = new Walnut(0, 500,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getXBackyard(),i.getYBackyard());
                    plantsList.add(walnut);
                }
                else if (i.getName().equals("IcePeaShooter")){
                    IcePeaShooter icePeaShooter = new IcePeaShooter(50, 200,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getXBackyard(),i.getYBackyard());
                    peaUpdateList.add(icePeaShooter.getPea());
                    plantsList.add(icePeaShooter);
                }

                i.currentPoint = new Point((int)i.getImageCorner().getX(),(int)i.getImageCorner().getY());
                i.setImageCorner(new Point((int)i.imageFirstPoint.getX(),(int)i.imageFirstPoint.getY()));
                i.check--;
            }

        }

    }

    public void updateShovel(Point point){
        for(Plants i : plantsList){
            if ( i.getXBackyard() == point.getX() && i.getYBackyard() == point.getY()){
                i.setImageActive(false);
                for(Pea j : peaUpdateList){
                    //if ((int) i.getImageFirstPoint().getX() == j.getXFirstCoordinate() && (int) i.getImageFirstPoint().getY() == j.getYFirstCoordinate()){
                        if (i.getXBackyard() == j.getXBackyard() && i.getYBackyard() == j.getYBackyard()){
                            if (!j.getStop()){
                                j.setShootActive(false);
                                j.setPrepareStop(true);
                                //j.setStop(true);
                                //i.getImageFirstPoint().setLocation(-500, -500);
                                break;
                            }
                    }
                }
            }
        }
        
    }

    public void drawShovel(GamePanel panel,Graphics g){
        shovel.getImage().paintIcon(panel, g,(int) shovel.getImageCorner().getX(),(int) shovel.getImageCorner().getY());
    }

    public void drawPlants(GamePanel panel,Graphics g){
        for(Plants j : plantsList){
            if (j.isImageActive())
                j.image.paintIcon(panel, g ,(int) j.currentPoint.getX(),(int) j.currentPoint.getY());
        }
    }

    public void drawPeaList(GamePanel panel,Graphics g){
        for(Pea i : peaUpdateList){
            if (!i.getStop())
                if (i.isImageActive())
                    if (i.getXCoordinate() > i.getXFirstCoordinate())
                        i.getImage().paintIcon(panel,g,i.getXCoordinate(),(int) i.getYCoordinate());
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
                if (Math.abs((int) i.getXCoordinate()-e.getPoint().getX()) <= i.getImage().getIconWidth()*1.5 && Math.abs((int) i.getYCoordinate()-e.getPoint().getY()) <= i.getImage().getIconHeight()*1.5){
                    i.setXCoordinate(15);
                    i.setYCoordinate(10);
                    sunValue += 50;
                    i.setImageActive(false);
                    break;
                }
        }
    }

    public void reset(){
        getPeaUpdateList().clear();
        getPlantsList().clear();
        getSunFallingList().clear();
        getSunList().clear();
        setSunValue(300);        
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

    public void setSunValue(int sunValue){
        this.sunValue = sunValue;
    }

    public Shovel getShovel(){
        return shovel;
    }


}
