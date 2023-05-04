package GUI_Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import Control.GamePanel;

public class Win {
    private int winDelay = 0;

    public void draw(GamePanel panel,Graphics2D g2D){
        if (checkDraw1()){
            draw1(panel, g2D);
        }
        if (checkDraw2()){
            draw2(panel, g2D);
        }
    }

    public void draw1(GamePanel panel,Graphics2D g2D){

    }

    public void draw2(GamePanel panel,Graphics2D g2D){
        g2D.setColor(Color.black);
        g2D.fillRect(0, 0, 1066, 600);
        
        g2D.setColor(Color.gray);
        g2D.fillRect(333, 100, 400, 400);
        
        g2D.setColor(Color.orange);
        g2D.fillRect(433, 400, 200, 50);
        g2D.setFont(new Font("MV Boli",Font.PLAIN,50));
        g2D.setColor(Color.white);
        g2D.drawString("Main Menu",433,450);
    }

    public boolean updateMainMenu(MouseEvent e){
        if (e.getY() >= 400 && e.getY() <= 400 + 50){
            if (e.getX() >= 433 && e.getX() <= 433 + 200){
                return true;
            }
        }
        return false;
    }

    public void setWinDelay(int delay){
        this.winDelay = delay;
    }

    public int getWinDelay(){
        return winDelay;
    }

    public boolean checkDraw1(){
        if (winDelay >= 50 && winDelay <= 200){
            return true;
        }
        return false;
    }

    public boolean checkDraw2(){
        if (winDelay > 200){
            return true;
        }
        return false;
    }
}
