package Others;

import java.awt.Graphics2D;

import java.util.ArrayList;
import java.util.Random;

import Zombies.Zombie_normal;
import Zombies.Zombies;

public class ObjectPvZ {
    public static ArrayList<Zombies> zombiesList;
    //ArrayList<Plants> plantsList = new ArrayList<Plants>();
    private int numZombies;
    //private int numPlants;
    Random random;
    
    public ObjectPvZ(int numPlants,int numZombies){
        //this.numPlants = numPlants;
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
                    zombiesList.add(new Zombie_normal(4, 200, 200+random.nextInt(400), 20 + random.nextInt(400)));
                    break; 
                }
            }
        }
    }

    //draw zombie in the screen
    public void addZombies(Graphics2D g2D,int x){
        for(Zombies i : zombiesList){
            g2D.drawImage(i.getImage(), x, i.getYCoordinate(), null);
        }
    }



}
