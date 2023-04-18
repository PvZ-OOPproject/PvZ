package Control;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Others.Backyard;
import Others.Card;
import Others.ObjectDrag;
import Others.ObjectPvZ;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GamePanel extends JPanel implements ActionListener{
    //size of panel
    final int PANEL_WIDTH = 1066;
    final int PANEL_HEIGHT = 600;

    //variable test
    Image zombie;
    Image backyardImage;
    Timer timer;
    int xVelocity = 1;
    int yVelocity = 1;
    int x = 1200;
    int y = 20;

    Point imageCorner;
    Point prePt;
    int check1 = 0;
    int check2;
    int check3 = 0;

    Backyard backyard;
    ObjectPvZ object;
    ObjectDrag objectDrag;
    Card card;


    public GamePanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT)); //set the size of this class
        this.setBackground(Color.black); //set background as black
        this.setDoubleBuffered(true); //set true: all the drawing from this component will be done in an offscreen painting buffer
        //in short, enabling this can improve game's rendering performance
        
        //declare test
        zombie = new ImageIcon("zombie_normal.gif").getImage();
        backyardImage = new ImageIcon("backyard.png").getImage();
        
        //DragPanel: use mouse to control plants
        imageCorner = new Point(0,0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
        
        objectDrag = new ObjectDrag();
        object = new ObjectPvZ(0,10);
        backyard = new Backyard();
        card = new Card();


        //timer = new Timer(10,this); //set up a loop of game
        //timer.start(); //run game
    }

    public void paint(Graphics g){
        
        super.paint(g); //paint background

        Graphics2D g2D = (Graphics2D) g;

        
        g2D.drawImage(backyardImage,0,0, null); // draw backyard
        
        // draw grid
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

        object.addZombies(g2D, x);
        objectDrag.addPlantsCard(this,g);
        objectDrag.updatePeaList(this,g);
        
        //draw plants can be clicked
    }

    //repaint the panel
    @Override
    public void actionPerformed(ActionEvent e) {
        x -= xVelocity;
        //objectDrag.addUpdatePea();
        repaint(); //another way to call method paint many times

    }


    //Control by mouse
    private class ClickListener extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            prePt = e.getPoint();
            //System.out.println(e.getX());
            //System.out.println(e.getY());
            //System.out.println(card.qualifiedPosition(e)[1]);
            if (card.qualifiedPosition(e)[1] == 1 && check1 == 0){
                check2 = card.qualifiedPosition(e)[0];
                check1++;
            }
        }
        public void mouseReleased(MouseEvent e){
            if (backyard.qualifiedPosition(e)[2] != 1){
                ObjectDrag.plantsCardList.get(check2).imageCorner = new Point((int)ObjectDrag.plantsCardList.get(check2).imageFirstPoint.getX(),(int)ObjectDrag.plantsCardList.get(check2).imageFirstPoint.getY());
            }
            else{
                int a = ObjectDrag.plantsCardList.get(check2).WIDTH;
                int b = ObjectDrag.plantsCardList.get(check2).HEIGHT;
                ObjectDrag.plantsCardList.get(check2).imageCorner = new Point(backyard.qualifiedPosition(e)[0]-a/2,backyard.qualifiedPosition(e)[1]-b);
                ObjectDrag.plantsCardList.get(check2).check++;
            }
            check1 = 0;
        }
        
    }
    //drag the image by mouse
    private class DragListener extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent e){
            Point currentPt = e.getPoint();
            ObjectDrag.plantsCardList.get(check2).imageCorner.translate((int)(currentPt.getX()-prePt.getX()),(int)(currentPt.getY()-prePt.getY()));
            prePt = currentPt;
            repaint();
        }
    }
    /*@Override
    /*public void run() {

    }*/

}
