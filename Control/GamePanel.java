package Control;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Others.Backyard;
import Others.Card;
import Others.ObjectDrag;
import Others.ObjectStable;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GamePanel extends JPanel implements ActionListener,Runnable{
    //size of panel
    public final int PANEL_WIDTH = 1066;
    public final int PANEL_HEIGHT = 600;

    //Timer timer;

    Point prePt;
    int check1 = 0;
    int check2 = -1;

    Backyard backyard;
    ObjectStable object;
    ObjectDrag objectDrag;
    Card card;


    public GamePanel(){
        
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT)); //set the size of this class
        this.setBackground(Color.black); //set background as black
        this.setDoubleBuffered(true); //set true: all the drawing from this component will be done in an offscreen painting buffer
        //in short, enabling this can improve game's rendering performance
        
        //DragPanel: use mouse to control plants
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
        
        // declare object
        objectDrag = new ObjectDrag(); // list of object can be controlled by mouse
        object = new ObjectStable(5); // list of object that are stable in game (such as zombie)
        backyard = new Backyard(); // contains the coordinate of every position in the backyard
        card = new Card(); // contains card price of plants

        /*JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 500, 500);
        

        JLabel label = new JLabel();
        label = new JLabel();

        String sunValue = String.valueOf(getSunValue());
        label.setText(sunValue);
        label.setForeground(Color.green);
        label.setFont(new Font("MV Boli",Font.PLAIN,20));
        label.setBackground(Color.blue);
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(15, 60, 55, 20);

        //layeredPane.add(label,JLayeredPane.DRAG_LAYER);

        //this.add(layeredPane);
        this.add(label,JLayeredPane.DRAG_LAYER);
        */

        // run a loop of game
        startGameThread(); 

        //timer = new Timer(10,this); //set up a loop of game
        //timer.start(); //run game
    }

    public void paint(Graphics g){
        
        super.paint(g); //paint background

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(new ImageIcon("backyard.png").getImage(),0,0, null); // draw backyard
        
        g2D.setFont(new Font("MV Boli",Font.PLAIN,20));
        g2D.setColor(Color.BLACK);
        g2D.drawString(String.valueOf(getSunValue()), 18, 78);


        // draw grid to 
        g2D.setColor(Color.BLACK);
        g2D.drawLine(0,80,1066,80);
        g2D.drawLine(0,180,1066,180);
        g2D.drawLine(0,280,1066,280);
        g2D.drawLine(0,380,1066,380);
        g2D.drawLine(0,480,1066,480);
        g2D.drawLine(0,580,1066,580);

        g2D.drawLine(250,0,250,600);
        g2D.drawLine(330,0,330,600);
        g2D.drawLine(410,0,410,600);
        g2D.drawLine(490,0,490,600);
        g2D.drawLine(570,0,570,600);
        g2D.drawLine(650,0,650,600);
        g2D.drawLine(730,0,730,600);
        g2D.drawLine(810,0,810,600);
        g2D.drawLine(890,0,890,600);
        g2D.drawLine(970,0,970,600);

        g2D.drawLine(80,0,80,600);
        g2D.drawLine(440,0,440,600);
        g2D.drawLine(0,75,1066,75);

        object.drawZombies(this, g); //draw zombie
        object.drawLawnMower(this, g);

        objectDrag.drawPlantsCard(this,g); //draw plants card
        objectDrag.drawPlants(this, g); //draw plants

        objectDrag.drawPeaList(this,g); //draw pea 
        objectDrag.drawSun(this, g); //draw sun from sunflower
        objectDrag.drawSunFalling(this, g);
        objectDrag.drawShovel(this, g);
        
        if (object.checkGameOver()){

            g2D.setColor(new Color(0,0,0,150));
            g2D.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

            g2D.setFont(new Font("MV Boli",Font.PLAIN,110));
            //Shadow
            g2D.setColor(Color.black);
            g2D.drawString("Game Over",250,300);
            //GameOver
            g2D.setColor(Color.white);
            g2D.drawString("Game Over",250-4,300-4);
            //Retry
            g2D.setFont(new Font("MV Boli",Font.PLAIN,50));
            g2D.setColor(Color.white);
            g2D.drawString("Retry",350,400);
            //Back to the title screen
            g2D.setColor(Color.white);
            g2D.drawString("Quit",600,400);   
            
            g2D.drawLine(350,0,350,600);
            g2D.drawLine(490,0,490,600);
            
            g2D.drawLine(0,400+10,1066,400+10);
            g2D.drawLine(0,360,1066,360);

            g2D.drawLine(600,0,600,600);
            g2D.drawLine(710,0,710,600);
            
        }
        //g2D.drawImage(new ImageIcon("shovel.png").getImage(),460,5,null);
    }

    //repaint the panel //skip: don't care this method
    @Override
    public void actionPerformed(ActionEvent e) {
        //x -= xVelocity;
        repaint(); 
    }


    //Control by mouse
    private class ClickListener extends MouseAdapter{
        // press the mouse in the card contain
        public void mouseClicked(MouseEvent e){
            if (!object.checkGameOver()){
                objectDrag.updateSunCard(e,objectDrag.getSunList());
                objectDrag.updateSunCard(e,objectDrag.getSunFallingList());
            }
            else{
                if (e.getY() >= 360 && e.getY() <= 410){
                    //click "retry"
                    if (e.getX() >= 350 && e.getX() <= 490){
                        objectDrag.reset();
                        object.reset();                        
                    }
                    //click "quit"
                    if (e.getX() >= 600 && e.getX() <= 710){

                    }
                }
            }
        }

        public void mousePressed(MouseEvent e){
            if (!object.checkGameOver()){
                prePt = e.getPoint();
                if (card.qualifiedPositionCard(e)[1] == 1 && check1 == 0){ //check the mouse can click the card properly
                    if (objectDrag.getSunValue() >= objectDrag.getPlantsCardList().get(card.qualifiedPositionCard(e)[0]).getPlantsValue()){
                        check2 = card.qualifiedPositionCard(e)[0]; //get position of the specific card in the card list
                        check1++; //purpose: to make sure to click only 1 card
                    }
                }
                if (objectDrag.getShovel().checkShovel(e)){
                    check2 = 8;
                }
            }
        }
        public void mouseReleased(MouseEvent e){
            if (!object.checkGameOver()){
                if (check2 >= 0 && check2 < 8){
                    if (backyard.qualifiedPositionBackyard(e)[2] != 1){ //check the mouse are placed in the proper area to place the plants in the backyard
                        objectDrag.getPlantsCardList().get(check2).imageCorner = new Point((int)ObjectDrag.plantsCardList.get(check2).imageFirstPoint.getX(),(int)ObjectDrag.plantsCardList.get(check2).imageFirstPoint.getY());
                        // a card is forced to move back to card list because the mouse place in area improperly to place plants 
                    }
                    else{
                        if (backyard.getAvailableCoordinate()[backyard.qualifiedPositionBackyard(e)[3]][backyard.qualifiedPositionBackyard(e)[4]] == 0){
                            backyard.getAvailableCoordinate()[backyard.qualifiedPositionBackyard(e)[3]][backyard.qualifiedPositionBackyard(e)[4]]++;
                            int a = objectDrag.getPlantsCardList().get(check2).getImage().getIconWidth();
                            int b = objectDrag.getPlantsCardList().get(check2).getImage().getIconHeight();
                            // get coordinate to place the plants
                            objectDrag.getPlantsCardList().get(check2).imageCorner = new Point(backyard.qualifiedPositionBackyard(e)[0]-a/2,backyard.qualifiedPositionBackyard(e)[1]-b);
                            objectDrag.getPlantsCardList().get(check2).check++; //set card are available to create a new plant
                            objectDrag.updateSunValue(objectDrag.getPlantsCardList().get(check2).getPlantsValue());
                        }
                        else
                            objectDrag.getPlantsCardList().get(check2).imageCorner = new Point((int)ObjectDrag.plantsCardList.get(check2).imageFirstPoint.getX(),(int)ObjectDrag.plantsCardList.get(check2).imageFirstPoint.getY());
                    }
                }
                else if (check2 == 8){
                    if (backyard.qualifiedPositionBackyard(e)[2] == 1){ //check the mouse are placed in the proper area to place the plants in the backyard
                        if (backyard.getAvailableCoordinate()[backyard.qualifiedPositionBackyard(e)[3]][backyard.qualifiedPositionBackyard(e)[4]] == 1){
                            objectDrag.updateShovel(new Point(backyard.qualifiedPositionBackyard(e)[0],backyard.qualifiedPositionBackyard(e)[1]));
                            backyard.getAvailableCoordinate()[backyard.qualifiedPositionBackyard(e)[3]][backyard.qualifiedPositionBackyard(e)[4]]--;
                        }
                        // a card is forced to move back to card list because the mouse place in area improperly to place plants 
                    }
                    objectDrag.getShovel().setImageCorner(new Point((int) objectDrag.getShovel().getImageFirstPoint().getX(),(int) objectDrag.getShovel().getImageFirstPoint().getY()));    
                }
                check1 = 0;
                check2 = -1;
            }
        }
        
    }
    //drag the image by mouse
    private class DragListener extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent e){
            if (!object.checkGameOver()){
                if (check2 >= 0 && check2 < 8){
                    //if (objectDrag.getSunValue() >= objectDrag.getPlantsList().get(check2).getPlantsValue()){
                    Point currentPt = e.getPoint();
                    // get new coordinate by using displacement between the current and the previous mouse
                    objectDrag.getPlantsCardList().get(check2).imageCorner.translate((int)(currentPt.getX()-prePt.getX()),(int)(currentPt.getY()-prePt.getY()));
                    prePt = currentPt;
                    repaint(); //repaint in a loop of game
                
                }
                else if (check2 == 8){
                    Point currentPt = e.getPoint();
                    // get new coordinate by using displacement between the current and the previous mouse
                    objectDrag.getShovel().imageCorner.translate((int)(currentPt.getX()-prePt.getX()),(int)(currentPt.getY()-prePt.getY()));
                    prePt = currentPt;
                    repaint(); //repaint in a loop of game
                }
            }  
        }
    }
    
    // program to create a loop of game
    private Thread gameThread;
    int FPS = 50; // frame per second
    public void startGameThread(){
        gameThread = new Thread(this);//instantiate a thread //passing GamePanel to thread's constructor 
        gameThread.start(); //let start a thread //automatically call run method
    }

    public void update(){
        if (!object.checkGameOver()){
            objectDrag.updatePeaList(); //update motion of pea of each peashooter
            object.updateLawnMower();
            object.updateZombies(); //update motion of each zombies
            object.checkCollision(objectDrag.getPlantsList(), objectDrag.getPeaUpdateList()); //check collision between objects (zombies vs pea and zombies vs plants)
            objectDrag.updateSunList();
            objectDrag.updateSunFalling();
            object.setAvailableCoordinate(backyard);
        }
    }
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0; 
        int drawCount = 0;
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;             
            }
            // display FPS
            if (timer >= 1000000000){
                System.out.println("FPS:"+drawCount);
                timer = 0;
                drawCount = 0;
            }  
        }
    }

    public int getSunValue(){
        return objectDrag.getSunValue();
    }

}
