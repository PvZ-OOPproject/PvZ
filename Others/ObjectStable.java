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
    public boolean gameOver = false;
    public boolean gameWin = false;
    private int delayZombies = 0;
    Random random;
    
    public ObjectStable(){ 
        zombiesList = new ArrayList<Zombies>();
        lawnMowersList = new ArrayList<LawnMower>();
        removeList = new ArrayList<>();
        random = new Random();
        //updateZombiesBackyard();
        updateLawnMowerBackyard();
        //updateTestZombies(1, 16);
    }
    
    //declare types of zombies
    enum Zombie {
        Normal,Football,Plastic,Iron;
    }

    //update zombies in this round
    /*public void updateZombiesBackyard(){
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
    }*/
    
    public void zombiesListName(int i,int j,int z){
        switch(j){
            case 0:{
                zombiesList.add(new Zombie_normal(-2, 200, 1200 + z*50, i*100,1000, 130 + i*100));
                break;
            }
            case 1:{
                zombiesList.add(new Zombie_normal(-2, 200, 1200 + z*50, i*100,1000, 130 + i*100));
                break;
            }
            case 2:{
                zombiesList.add(new Zombie_normal(-2, 200, 1200 + z*50, i*100,1000, 130 + i*100));
                break;
            }                
        }
    }

    public void addTurnZombies(int numBegin,int numEnd,int typeBegin,int typeEnd){
        int k = numBegin + random.nextInt(numEnd - numBegin + 1);
        int z = 0;
        while (z < k){
            int i = random.nextInt(5);
            int j = typeBegin + random.nextInt(typeEnd - typeBegin + 1);
            zombiesListName(i, j,0);
            z++;
        }
    }
    public void addFinalZombies(int num){      
        int a = num/5;
        int b = num % 5;
        int[] list1 = {a,a,a,a,a};

        for(int i = 0; i < b;i++)
            list1[i]++;
        
        int[] list2 = {-1,-1,-1,-1,-1};
        for(int i = 0;i < 5;i++){
            while(true){
                int j = random.nextInt(5);
                if (list2[j] == -1){
                    list2[j] = list1[i];
                    break;
                }
            }
        }
        int limit = 3;
        int count = 0;
        int test;
        if (b == 0)
            test = a;
        else
            test = a + 1;
        for(int k = 0; k < test;k++){
            for(int i = 0; i < 5;i++){
                if (k < list2[i]){                    
                    if (count < limit){
                        zombiesListName(i, count,k);
                        count++;
                    }
                    else{
                        int j = random.nextInt(limit);
                        zombiesListName(i,j,k);
                    }
                }
            }
        }
    }



    public boolean readyToAddZombies(){        
        for(Zombies i : zombiesList){
            if (i.getHealth() <= (int) i.getFirstHealth()/2 && i.getCheck() == 0){
                for(Zombies j : zombiesList){
                    j.setCheck(1);
                }
                return true; 
            }
        }
        return false;
    }

    public boolean checkFinal(){
        for(Zombies i : zombiesList){
            if (i.getHealth() > 0){
                return false;
            }
        }
        return true;
    }

    public void updateTestZombies(int turn,int numTurn,int numFinal){
        if (zombiesList.size() < numTurn){
            if ( delayZombies < 400){
                delayZombies += 2;
            }
            else{
                if (zombiesList.size() == 0){
                    addTurnZombies(1,1, 0, 2);
                }
                else{
                    if (readyToAddZombies())
                        addTurnZombies(1,2, 0, 2);
                }
            }
        }
        else{
            if (checkFinal() && gameWin == false){
                addFinalZombies(numFinal);
                gameWin = true;
            }
        }
        //System.out.println(zombiesList.size());

        
        
        
        /*int n = 16;
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
                /*switch(z){
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
        }*/
        
    }

    public void updateLawnMowerBackyard(){
        for(int i = 0; i < 5;i++){
            lawnMowersList.add(new LawnMower(210, 130 + i*100,210,130 + i*100));
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
            if (i.isImageActive())
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
            if (checkZombiesLine(zombiesList,i.getXFirstCoordinate() ,i.getYBackyard()) && !i.getPrepareStop()){
                i.setShootActive(true);
            }            
            else
                i.setShootActive(false);
        }

        for(Zombies i : zombiesList){
            if (checkInteract(plantsList, i))
                i.setStopMotion(true);
            else
                i.setStopMotion(false);
        }
        
        for(Zombies i : zombiesList){
            if (i.getXCoordinate() <= 1000){
            //Rectangle2D.Float r = i.getHitBox();
                for(Plants j : plantsList){
                    if (i.getHitBox().intersects(j.getHitBox())){
                        if (j.isImageActive()){
                            j.plantHit(i.getDamage());
                            if (j.getHealth() <= 0){
                                j.setImageActive(false);
                            }
                            //i.setStop(true);
                        }
                        else{
                            j.setPos(-500, -500);
                            removeList.add(j);
                            }
                        }
                }
                for(Pea k : peaUpdateList){
                    for(Plants m : removeList){
                        //if ((int) m.getImageFirstPoint().getX() == k.getXFirstCoordinate() && (int) m.getImageFirstPoint().getY() == k.getYFirstCoordinate()){
                        if (m.getXBackyard() == k.getXBackyard() && m.getYBackyard() == k.getYBackyard()){ 
                            k.setStop(true);
                            //m.getImageFirstPoint().setLocation(-500, -500);
                        }
                    }
                    if (i.getHitBox().intersects(k.getHitBox())){
                        if (k.isImageActive()){
                            //i.zombieHit(k.getDamage());
                            //k.setImageActive(false);
                            k.effectOnZombies(i);
                            if (i.getHealth() <= 0){
                                i.setImageActive(false);
                            }
                        }
                    }
                }
                for(LawnMower n: lawnMowersList){
                    if (n.getYBackyard() == i.getYBackyard())
                        if (i.getHitBox().intersects(n.getHitBox())){
                            i.setHealth(0);
                            n.setImageActive(false);
                            i.setImageActive(false);
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
            if (i.getYBackyard() == y && i.getXCoordinate() <= 1000){
                if (x < i.getXCoordinate())
                    return true; 
            }
        }
        return false;
    }
    
    public void reset(){
        zombiesList.clear();
        //updateZombiesBackyard();
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
            if (i.getYBackyard() == j.getYBackyard())
                if (j.getHitBox().intersects(i.getHitBox()))
                    return true;
        }
        return false;
    }
}    




