package GUI_Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import Control.GamePanel;

public class Menu {
    
    public void draw(GamePanel panel,Graphics2D g2D){
        g2D.setColor(Color.BLACK);
        g2D.fillRect(333, 100, 400, 400);

        g2D.setFont(new Font("MV Boli",Font.PLAIN,50));
        

        g2D.setColor(Color.gray);
        g2D.fillRect(343, 410, 380, 80);
        g2D.setColor(Color.white);
        g2D.drawString("Back to Game",343,410+50);

        g2D.setFont(new Font("MV Boli",Font.PLAIN,40));
        g2D.setColor(Color.gray);
        g2D.fillRect(433, 360, 200, 40);
        g2D.setColor(Color.white);
        g2D.drawString("Main Menu",433,360+40);

        g2D.setColor(Color.gray);
        g2D.fillRect(433, 310, 200, 40);
        g2D.setColor(Color.white);
        g2D.drawString("Restart level",433,310+40);

        g2D.setColor(Color.gray);
        g2D.fillRect(433, 260, 200, 40);

        g2D.setColor(Color.gray);
        g2D.fillRect(383, 200, 300, 40);
        g2D.setColor(Color.white);
        g2D.drawString("Sound FX",433,200+40);        

        g2D.setColor(Color.gray);
        g2D.fillRect(383, 150, 300, 40);
        g2D.setColor(Color.white);
        g2D.drawString("Music",433,150+40);
    }

    public boolean updateBackToGame(MouseEvent e){
        if (e.getX() >= 343 && e.getX() <= 343 + 380){
            if (e.getY() >= 410 && e.getY() <= 410 + 80){
                return true;
            }
        }
        return false;
    }

    public boolean updateMainMenu(MouseEvent e){
        if (e.getX() >= 433 && e.getX() <= 433 + 200){
            if (e.getY() >= 360 && e.getY() <= 360 + 40){
                return true;
            }
        }
        return false;
    } 


    public boolean updateRestart(MouseEvent e){
        if (e.getX() >= 433 && e.getX() <= 433 + 200){
            if (e.getY() >= 310 && e.getY() <= 310 + 40){
                return true;
            }
        }
        return false;
    } 
}
