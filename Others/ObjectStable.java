package Others;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import Control.GamePanel;
import Plants.Pea;
import Plants.Plants;
import Zombies.Zombie_normal;
import Zombies.Zombies;

public class ObjectStable {
    public static ArrayList<Zombies> zombiesList;
    public static ArrayList<LawnMower> lawnMowersList;
    public static ArrayList<Plants> removeList;
    public static boolean gameOver = false;
    private int numZombies;
    Random random;
    
    public ObjectStable(int numZombies){
        this.numZombies = numZombies; 
        zombiesList = new ArrayList<Zombies>();
        lawnMowersList = new ArrayList<LawnMower>();
        removeList = new ArrayList<>();
        random = new Random();
        updateZombiesBackyard();
        updateLawnMowerBackyard();
        //updateTestZombies(1, 16);
    }
    
    //declare types of zombies
    enum Zombie {
        Normal,Football,Plastic,Iron;
    }

    //update zombies in this round
    public void updateZombiesBackyard(){
        for(int i=0; i < numZombies;i++){
            //int j = random.nextInt(4);
            int j = 1;
            switch(j){
                case 1:{
                    zombiesList.add(new Zombie_normal(-1, 200, 1000+random.nextInt(1), i*100,1000,130 + i*100));
                    zombiesList.add(new Zombie_normal(-1, 200, 2200+random.nextInt(400), i*100,1000,130 + i*100));
                    zombiesList.add(new Zombie_normal(-1, 200, 2200+random.nextInt(400), i*100,1000,130 + i*100));
                    //zombiesList.add(new Zombie_normal(-1, 200, 1000+random.nextInt(400), i*100));
                    //zombiesList.add(new Zombie_normal(-1, 200, 1000+random.nextInt(400), i*100));
                    break; 
                }
            }
        }
    }

    /*public void updateTestZombies(int turn,int numZombies){
        int n = 16;
        int a = 3 + random.nextInt(2);
        int b = 2 + random.nextInt(3);
        int c = 2 + random.nextInt(2);
        int d;
        if (a + b + c >= 10){
            d = 2 + random.nextInt(2);
        }
        else {
            d = 3 + random.nextInt(2);
        }
        int e = n - a - b - c - d;
        int[] list = {a,b,c,d,e};

        for(int i = 0; i < 5;i++){
            for(int j = 0; j < list[i];j++){
                int z = random.nextInt(3);
                switch(z){
                    case 0:{
                        zombiesList.add(new Zombie_normal(-1, 200, 1000 + j*50, i*100));
                        break;
                    }
                    case 1:{
                        zombiesList.add(new Zombie_normal(-1, 200, 1000 + j*50, i*100));
                        break;
                    }
                    case 2:{
                        zombiesList.add(new Zombie_normal(-1, 200, 1000 + j*50, i*100));
                        break;
                    }
                }
            }
        }
        
    }*/

    public void updateLawnMowerBackyard(){
        for(int i = 0; i < 5;i++){
            lawnMowersList.add(new LawnMower(210, 130 + i*100));
        }
    }

    public void drawLawnMower(GamePanel panel,Graphics g){
        for(LawnMower i : lawnMowersList)
            if (i.getXCoordinate() <= 1000)
                i.getImage().paintIcon(panel, g,(int) i.getXCoordinate(),(int) i.getYCoordinate());
    }

    //draw zombie in the screen
    public void drawZombies(GamePanel panel,Graphics g){
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
        }
    }

    public void updateLawnMower(){
        for(LawnMower i : lawnMowersList){
            i.updateLawnMower();
        }
    }

    public void checkCollision(ArrayList<Plants> plantsList, ArrayList<Pea> peaUpdateList){
        for(Pea i : peaUpdateList){
            if (checkZombiesLine(zombiesList,i.getXFirstCoordinate() ,i.getYBackyard())){
                i.setShootActive(true);
            }            
            else
                i.setShootActive(false);
            
        }

        for(Zombies i : zombiesList){
            if (checkInteract(plantsList, i))
                i.setStop(true);
            else
                i.setStop(false);
        }
        
        for(Zombies i : zombiesList){
            if (i.getXCoordinate() <= 1000){
            //Rectangle2D.Float r = i.getHitBox();
                for(Plants j : plantsList){
                    if (i.getHitBox().intersects(j.getHitBox())){
                        if (j.isActive()){
                            j.plantHit(i);
                            if (j.getHealth() <= 0){
                                j.setActive(false);
                            }
                            //i.setStop(true);
                        }
                        else{
                            j.setPos(-500, -500);
                            removeList.add(j);
                            }
                        }
                    /*else
                        i.setStop(false);*/
                    //System.out.println(removeList.size());
                }
                for(Pea k : peaUpdateList){
                    for(Plants m : removeList){
                        if ((int) m.getImageFirstPoint().getX() == k.getXFirstCoordinate() && (int) m.getImageFirstPoint().getY() == k.getYFirstCoordinate()){
                            k.setStop(true);
                            m.getImageFirstPoint().setLocation(-500, -500);
                        }
                    }
                    if (i.getHitBox().intersects(k.getHitBox())){
                        if (k.isActive()){
                            i.zombieHit(k.getDamage());
                            k.setActive(false);
                            if (i.getHealth() <= 0){
                                i.setActive(false);
                            }
                        }
                    }
                }
                for(LawnMower n: lawnMowersList){
                    if (i.getHitBox().intersects(n.getHitBox())){
                        n.setActive(false);
                        i.setActive(false);
                    }
                }
                if (i.checkGameOver())
                    gameOver = true;
            }
        }
        //removeList.clear();
    }

    public boolean checkZombiesLine(ArrayList<Zombies> zombiesList,int x,int y){
        for(Zombies i : zombiesList){
            if (Math.abs(i.getYBackyard() - y) <= 10 && i.getXCoordinate() <= 1000){
                if (x < i.getXCoordinate())
                    return true; 
            }
        }
        return false;
    }

    public boolean checkZombiesFront(int x){
        for(Zombies i : zombiesList){
            if (x < i.getXCoordinate()){
                return true; 
            }
        }
        return false; 
    }
    
    public void reset(){
        zombiesList.clear();
        updateZombiesBackyard();
        lawnMowersList.clear();
        updateLawnMowerBackyard();
        gameOver = false;
    }

    public boolean checkGameOver(){
        return gameOver;
    }

    public int[] getAvailableCoordinate(Backyard a ,int x,int y){
        int[] b = {0,0};
        for(int i = 0; i < a.getRows().length;i++)
            if (a.getRows()[i] == y){
                b[0] = i;
            }
        for(int j = 0; j < a.getColumns().length;j++)
            if (a.getColumns()[j] == x){
                b[1] = j;
            }

        return b;
    }

    public void setAvailableCoordinate(Backyard a){
        int[] b;
        for(Plants i : removeList){
            b = getAvailableCoordinate(a, i.getXBackyard(), i.getYBackyard());
            if (a.getAvailableCoordinate()[b[0]][b[1]] == 1)
                a.getAvailableCoordinate()[b[0]][b[1]] = 0;
        }
        removeList.clear();
    }

    public boolean checkInteract(ArrayList<Plants> plantsList,Zombies j){
        for(Plants i : plantsList){
            if (j.getHitBox().intersects(i.getHitBox()))
                return true;
        }
        return false;
    }
}    




