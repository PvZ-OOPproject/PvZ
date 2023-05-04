package GUI_Game;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

import Control.GamePanel;

public class GameOver {
    
    public void draw(GamePanel panel,Graphics2D g2D){
        g2D.setColor(Color.black);
        g2D.fillRect(0, 0, 1066, 600);
        g2D.drawImage(new ImageIcon("game_over.jpg").getImage(),112,0,null);

        //g2D.setColor(new Color(0,0,0,150));
        //g2D.fillRect(0, 0, 1066, 600);

        g2D.setFont(new Font("MV Boli",Font.PLAIN,110));
        
        /* 
        //Shadow
        g2D.setColor(Color.black);
        g2D.drawString("Game Over",250,300);
        //GameOver
        g2D.setColor(Color.white);
        g2D.drawString("Game Over",250-4,300-4);
        */
        //Retry
        g2D.setFont(new Font("MV Boli",Font.PLAIN,50));

        g2D.setColor(Color.white);
        g2D.drawString("Retry",350-1,540-1);
        g2D.setColor(Color.green);
        g2D.drawString("Retry",350,540);

        //Back to the title screen
        g2D.setColor(Color.white);
        g2D.drawString("Quit",630-1,540-1);   
        g2D.setColor(Color.green);
        g2D.drawString("Quit",630,540); 
        
        g2D.setColor(Color.white);
        g2D.drawLine(350,0,350,600);
        g2D.drawLine(490,0,490,600);
        
        g2D.drawLine(0,500,1066,500);
        g2D.drawLine(0,550,1066,550);

        g2D.drawLine(630,0,630,600);
        g2D.drawLine(740,0,740,600);
        
    }

    public boolean updateRestart(MouseEvent e){
        if (e.getY() >= 500 && e.getY() <= 550){
            if (e.getX() >= 350 && e.getX() <= 490){
                return true;                  
            }        
        }
        return false;
    }

    public boolean updateQuit(MouseEvent e){
        if (e.getY() >= 500 && e.getY() <= 550){
            if (e.getX() >= 630 && e.getX() <= 740){
                return true;                  
            }        
        }
        return false;
    }
}
