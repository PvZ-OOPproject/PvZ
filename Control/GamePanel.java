package Control;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import GUI_Game.AudioOptions;
import GameState.*;
import GameState.LevelState.Level;
import GameState.MainMenuState.MainMenu;
import GameState.PlayingState.Playing;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GamePanel extends JPanel implements ActionListener,Runnable{
    //size of panel
    public final int PANEL_WIDTH = 1066;
    public final int PANEL_HEIGHT = 600;

    // program to create a loop of game
    private Thread gameThread;
    private int FPS = 50; // frame per second

    State state;

    Playing playing;
    
    MainMenu mainMenu;

    Level level;

    AudioOptions audioOptions;

    AudioPlayer audioPlayer;


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

        audioPlayer = new AudioPlayer("song",1);
        audioPlayer.playSong(0);

        audioOptions = new AudioOptions(audioPlayer,this);
        
        
        state = new State(this);
        level = new Level(this);
        mainMenu = new MainMenu(this,level);
        playing = new Playing(this,level,mainMenu);
    
        // run a loop of game
        startGameThread(); 

    }

    public void update(){
        switch (GameState.state){
            case MAIN_MENU:{
                mainMenu.update();
                break;
            }
            case PLAYING: {
                playing.update();
                break;
            }
            case LEVEL: {
                level.update();
                break;
            }
        }
    }

    public void paint(Graphics g){
        
        super.paint(g); //paint background

        Graphics2D g2D = (Graphics2D) g;

        switch(GameState.state){
            case MAIN_MENU:
                mainMenu.draw(this, g2D,g);
                break;
            case PLAYING:
                playing.draw(this, g2D, g);
                break;
            case LEVEL:
                level.draw(this, g2D, g);
        }

    }

    // program to create a loop of game
    public void startGameThread(){
        gameThread = new Thread(this);//instantiate a thread //passing GamePanel to thread's constructor 
        gameThread.start(); //let start a thread //automatically call run method
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

    //repaint the panel //skip: don't care this method 
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint(); 
    }

    private class ClickListener extends MouseAdapter{
        public void mouseClicked(MouseEvent e){
            switch(GameState.state){
                case MAIN_MENU:
                    mainMenu.mouseClicked(e);
                    break;
                case PLAYING:
                    playing.mouseClicked(e);
                    break;
                case LEVEL:
                    break;
            }
        }

        public void mousePressed(MouseEvent e){
            switch(GameState.state){
                case MAIN_MENU:
                    mainMenu.mousePressed(e);
                    break;
                case PLAYING:
                    playing.mousePressed(e);
                    break;
                case LEVEL:
                    level.mousePressed(e);
                    break;
            }            

        }
        public void mouseReleased(MouseEvent e){
            switch(GameState.state){
                case MAIN_MENU:
                    mainMenu.mouseReleased(e);
                    break;
                case PLAYING:
                    playing.mouseReleased(e);
                    break;
                case LEVEL:
                    level.mouseReleased(e);
                    break;
            }
        }
        
    }
    private class DragListener extends MouseMotionAdapter{
        public void mouseMoved(MouseEvent e){
            switch(GameState.state){
                case MAIN_MENU:
                    mainMenu.mouseMoved(e);
                    break;
                case PLAYING:
                    playing.mouseMoved(e);
                    break;
                case LEVEL:
                    level.mouseMoved(e);
                    break;
            }
        }

        public void mouseDragged(MouseEvent e){
            switch(GameState.state){
                case MAIN_MENU:
                    mainMenu.mouseDragged(e);
                    break;
                case PLAYING:
                    playing.mouseDragged(e);
                    break;            
            }
        }
    }
     
    public AudioPlayer getAudioPlayer(){
        return audioPlayer;
    }

    public AudioOptions getAudioOptions(){
        return audioOptions;
    }


}

