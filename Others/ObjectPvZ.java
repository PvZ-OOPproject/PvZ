package Others;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import Control.GamePanel;
import Plants.Pea;
import Plants.Plants;
import Zombies.Zombie_normal;
import Zombies.Zombies;

public class ObjectPvZ {
    public static ArrayList<Zombies> zombiesList;
    private int numZombies;
    Random random;
    
    public ObjectPvZ(int numZombies){
        this.numZombies = numZombies; 
        zombiesList = new ArrayList<Zombies>();
        random = new Random();
        update();
    }
    
    //declare types of zombies
    enum Zombie {
        Normal,Football,Plastic,Iron;
    }

    //update zombies in this round
    public void update(){
        for(int i=0; i < numZombies;i++){
            //int j = random.nextInt(4);
            int j = 1;
            switch(j){
                case 1:{
                    zombiesList.add(new Zombie_normal(-1, 200, 1000+random.nextInt(400), i*100));
                    //zombiesList.add(new Zombie_normal(-1, 200, 1000+random.nextInt(400), i*100));
                    //zombiesList.add(new Zombie_normal(-1, 200, 1000+random.nextInt(400), i*100));
                    break; 
                }
            }
        }
    }

    //draw zombie in the screen
    public void drawZombies(GamePanel panel,Graphics g){
        //ArrayList<Integer> indexList = new ArrayList<>();
        
        for(Zombies i : zombiesList){
            if (i.isActive())
            //g2D.drawImage(i.getImage(), x, i.getYCoordinate(), null);
                i.image.paintIcon(panel, g, i.getXCoordinate(),i.getYCoordinate());
                //indexList.add(zombiesList.indexOf(i);
        }
    }

    public void updateZombies(){
        for(Zombies i : zombiesList){
            i.updateXCoordinate();
            //System.out.println(i.getHealth());
        }
    }

    public void checkCollision(ArrayList<Plants> plantsList, ArrayList<Pea> peaUpdateList){
        for(Zombies i : zombiesList){
            if (i.getXCoordinate() <= 1000){
            //Rectangle2D.Float r = i.getHitBox();
                ArrayList<Plants> removeList = new ArrayList<>();
                for(Plants j : plantsList){
                    if (i.getHitBox().intersects(j.getHitBox())){
                        if (j.isActive()){
                            j.plantHit(i);
                            i.setStop(true);
                        }
                        else{
                            j.setPos(-500, -500);
                            removeList.add(j);
                            }
                        }
                    else
                        i.setStop(false);
                }
                for(Pea k : peaUpdateList){
                    for(Plants m : removeList){
                        if ((int) m.getImageFirstPoint().getX() == k.getXFirstCoordinate())
                            k.setStop(true);
                    }
                    if (i.getHitBox().intersects(k.getHitBox())){
                        if (k.isActive()){
                            i.zombieHit(k);
                            k.setActive(false);
                        }
                    }
                }
            }
        }
    }



}
