package Others;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import Control.AudioPlayer;
import Control.GamePanel;


import Plants.CherryBomb;
import Plants.DoomShroom;
import Plants.DoublePeaShooter;
import Plants.IcePeaShooter;
import Plants.IceShroom;
import Plants.Jalapeno;
import Plants.NewPlant;
import Plants.Pea;
import Plants.PeaShooter;
import Plants.Plants;
import Plants.PotatoMine;
import Plants.RandomPlants;
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

    private AudioPlayer audioPlayer;

    public ObjectDrag(AudioPlayer audioPlayer){
        plantsCardList = new ArrayList<Plants>();
        plantsList = new ArrayList<Plants>();
        peaUpdateList = new ArrayList<>();
        sunFlowerList = new ArrayList<>();
        sunUpdateList = new ArrayList<>();
        sunFallingUpdateList = new ArrayList<>();
        random = new Random();
        shovel = new Shovel(460, 5);

        this.audioPlayer = audioPlayer;

        update();
    }

    public void update(){
        for(int i=1; i <= 9;i++){
            //int j = random.nextInt(4);
            //int j = 2;
            switch(i){
                case 1:{
                    plantsCardList.add(new PeaShooter(20, 300, 80 + (i-1)*52, 5,40,80 + 26 + (i-1)*52));
                    break; 
                }
                case 2:{
                    plantsCardList.add(new SunFlower(0, 300, 80 + (i-1)*52, 5,40,80 + 26 + (i-1)*52));
                    break;                     
                }
                case 3:{
                    plantsCardList.add(new Walnut(0, 4000, 80 + (i-1)*52, 5,40,80 + 26 + (i-1)*52));
                    break;                     
                }
                case 4:{
                    plantsCardList.add(new DoublePeaShooter(20, 300, 80 + (i-1)*52, 5,40,80 + 26 + (i-1)*52));
                    break;                    
                }
                case 5:{
                    plantsCardList.add(new IcePeaShooter(20, 300, 80 + (i-1)*52, 5,40,80 + 26 + (i-1)*52));
                    break;                   
                }
                case 6:{
                    plantsCardList.add(new CherryBomb(1800, 1800, 80 + (i-1)*52, 5,40,80 + 26 + (i-1)*52,audioPlayer));
                    break;                       
                }
                case 7:{
                    plantsCardList.add(new PotatoMine(1800, 300, 80 + (i-1)*52, 5,40,80 + 26 + (i-1)*52,audioPlayer));
                    break;                     
                }
                case 8:{
                    plantsCardList.add(new NewPlant(1800, 1800, 730 - 52, 5,40,730 + 26 - 52));
                    break;                       
                }
                case 9:{
                    plantsCardList.add(new RandomPlants(1800, 300, 730, 5,40,730 + 26));
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
            i.getImage().paintIcon(panel, g,(int) i.getXCoordinate(),(int) i.getYCoordinate());
        }
    }

    public void updatePlantsCard(){
        for(Plants i : plantsCardList){
            if (i.check == 0){
                if (i.getCheckDelay()){
                    i.setDelay(i.getDelay()+1);
                    if (i.getDelay() == i.getConstDelay()){
                        i.setCheckDelay(false);
                        i.setDelay(0);
                    }
                }
            }
        }
    }

    public void drawPlantsCard(GamePanel panel,Graphics g){
        for(Plants i : plantsCardList){
            if (i.check == 0)
                if (!i.getCheckDelay())
                    if (this.getSunValue() >= i.getPlantsValue())
                        i.getCardImage().paintIcon(panel, g ,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY());
                    else
                        i.getImageDelay().paintIcon(panel, g ,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY());
                else{
                    i.getImageDelay().paintIcon(panel, g ,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY());
                    
                    g.setColor(new Color(0,0,0,150));
                    g.fillRect((int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getCardImage().getIconWidth(), i.getCardImage().getIconHeight() - (int)((double) 70 / i.getConstDelay() * i.getDelay()));
                }
            else{
                if (i.getName().equals("PeaShooter")){
                    PeaShooter peaShooter = new PeaShooter(20, 300,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getXBackyard(),i.getYBackyard());
                    peaUpdateList.add(peaShooter.getPea());
                    plantsList.add(peaShooter);
                }
                else if (i.getName().equals("SunFlower")){
                    SunFlower sunFlower = new SunFlower(0, 300, (int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getXBackyard(),i.getYBackyard());
                    plantsList.add(sunFlower);
                    sunFlowerList.add(sunFlower);
                }
                else if (i.getName().equals("DoublePeaShooter")){
                    DoublePeaShooter doublePeaShooter = new DoublePeaShooter(20, 300,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getXBackyard(),i.getYBackyard());
                    peaUpdateList.add(doublePeaShooter.getPea1());
                    peaUpdateList.add(doublePeaShooter.getPea2());
                    plantsList.add(doublePeaShooter);
                }
                else if (i.getName().equals("Walnut")){
                    Walnut walnut = new Walnut(0, 4000,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getXBackyard(),i.getYBackyard());
                    plantsList.add(walnut);
                }
                else if (i.getName().equals("IcePeaShooter")){
                    IcePeaShooter icePeaShooter = new IcePeaShooter(20, 300,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getXBackyard(),i.getYBackyard());
                    peaUpdateList.add(icePeaShooter.getPea());
                    plantsList.add(icePeaShooter);
                }
                else if (i.getName().equals("CherryBomb")){
                    CherryBomb cherryBomb = new CherryBomb(1800, 1800,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getXBackyard(),i.getYBackyard(),audioPlayer);
                    plantsList.add(cherryBomb);
                }
                else if (i.getName().equals("PotatoMine")){
                    PotatoMine potatoMine = new PotatoMine(1800, 300,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getXBackyard(),i.getYBackyard(),audioPlayer);
                    plantsList.add(potatoMine);
                }
                else if (i.getName().equals("NewPlant")){
                    NewPlant newPlant = new NewPlant(20, 4000,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getXBackyard(),i.getYBackyard());
                    plantsList.add(newPlant);
                }
                else if (i.getName().equals("RandomPlants")){
                    int j = 1 + random.nextInt(10);
                    //int j = 2;
                    switch(j){
                        case 1, 2, 3:{
                            IceShroom iceShroom = new IceShroom(20, 1800,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getXBackyard(),i.getYBackyard(),audioPlayer);
                            plantsList.add(iceShroom);
                            break;
                        }
                        case 4 ,5, 6, 7:{
                            Jalapeno jalapeno = new Jalapeno(1800, 1800,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getXBackyard(),i.getYBackyard(),audioPlayer);
                            plantsList.add(jalapeno);
                            break;
                        }
                        case 8, 9, 10:{
                            DoomShroom doomShroom = new DoomShroom(1800, 1800,(int) i.getImageCorner().getX(),(int) i.getImageCorner().getY(), i.getXBackyard(),i.getYBackyard(),audioPlayer);
                            plantsList.add(doomShroom);
                            break;
                        }
                    }
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
                              
                                
                                //break;
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
            j.draw(panel, g);
        }
    }

    public void drawPeaList(GamePanel panel,Graphics g){
        for(Pea i : peaUpdateList){
            if (!i.getStop())
                if (i.isImageActive())
                    if (i.getXCoordinate() > i.getXFirstCoordinate())
                        i.getImage().paintIcon(panel,g,(int) i.getXCoordinate(),(int) i.getYCoordinate());
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

    public void updatePlantsList(){
        for(Plants i : plantsList){
            i.update();
        }
    }

    public void updateSunCard(MouseEvent e,ArrayList<Sun> sunList){
        for(Sun i : sunList){
            if (i.getYCoordinate() >= 80)
                if (Math.abs((int) i.getXCoordinate()-e.getPoint().getX()) <= i.getImage().getIconWidth()*1.5 && Math.abs((int) i.getYCoordinate()-e.getPoint().getY()) <= i.getImage().getIconHeight()*1.5){
                    i.setXCoordinate(15);
                    i.setYCoordinate(10);
                    sunValue += 25;
                    i.setImageActive(false);

                    AudioPlayer sound = new AudioPlayer("sunning", 2);
                    sound.setVolume(audioPlayer.getVolume());
                    if (!audioPlayer.getEffectMute())
                        sound.playEffect();
                    break;
                }
        }
    }

    public void reset(){
        getPlantsCardList().clear();
        update();
        getSunFlowerList().clear();
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
            i.getImage().paintIcon(panel, g,(int) i.getXCoordinate(),(int) i.getYCoordinate());
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

    public ArrayList<SunFlower> getSunFlowerList(){
        return sunFlowerList;
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
