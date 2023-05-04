package GUI_Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;


import Control.GamePanel;

public class MainMenu {
    private Quit quit;
    private boolean quitState = false;

    public MainMenu(){
        quit = new Quit();
    }

    public void draw(GamePanel panel,Graphics2D g2D){
        g2D.setColor(Color.BLACK);
        g2D.fillRect(0, 0, 1066, 600);
        
        g2D.setColor(Color.GRAY);
        g2D.fillRect(500, 100, 400, 400);

        g2D.setColor(Color.ORANGE);
        g2D.fillRect(525, 125, 350, 160);
        g2D.setFont(new Font("MV Boli",Font.PLAIN,50));
        g2D.setColor(Color.white);
        g2D.drawString("Adventure",525,175);

        g2D.setColor(Color.ORANGE);
        g2D.fillRect(525, 315, 350, 160);

        g2D.setColor(Color.white);
        g2D.drawString("Quick play",525,365);

        g2D.setColor(Color.BLUE);
        g2D.fillRect(900, 500, 70, 70);
        
        if (quitState){
            quit.draw(panel, g2D);
        }
        
    }
 
    public boolean updatePlaying(MouseEvent e){
        if (e.getX() >= 525 && e.getX() <= 525 + 350){
            if (e.getY() >= 315 && e.getY() <= 315 + 160){
                return true;
            }
        }
        return false;
    }

    public boolean updateQuit(MouseEvent e){
        if (e.getX() >= 900 && e.getX() <= 900 + 70){
            if (e.getY() >= 500 && e.getY() <= 500 + 70){
                return true;
            }
        }
        return false;
    }

    public Quit getQuit(){
        return quit;
    }

    public boolean getQuitState(){
        return quitState;
    }
    
    public void setQuitState(boolean active){
        this.quitState = active;
    }
}
