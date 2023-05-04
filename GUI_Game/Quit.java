package GUI_Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import Control.GamePanel;

public class Quit {
    public void draw(GamePanel panel,Graphics2D g2D){
        g2D.setColor(new Color(0,0,0,150));
        g2D.fillRect(0, 0, 1066, 600);        

        g2D.setColor(Color.gray);
        g2D.fillRect(383, 200, 300, 200);

        g2D.setFont(new Font("MV Boli",Font.PLAIN,20));
        g2D.setColor(Color.white);
        g2D.drawString("Are you sure to leave?",408 - 15,250);

        g2D.setFont(new Font("MV Boli",Font.PLAIN,50));
        g2D.setColor(Color.orange);
        g2D.fillRect(408 - 15, 320, 135, 70);
        g2D.setColor(Color.white);
        g2D.drawString("Leave",408 - 15,320 + 50);

        g2D.setColor(Color.orange);
        g2D.fillRect(408 + 130, 320, 135, 70);
        g2D.setColor(Color.white);
        g2D.drawString("Cancel",408+130,320 + 50);
    }

    public boolean updateCancel(MouseEvent e){
        if (e.getY() >= 320 && e.getY() <= 320 + 70){
            if (e.getX() >= 408 + 130 && e.getX() <= 408 + 130 + 135){
                return true;
            }
        }
        return false;
    }

    public boolean updateLeave(MouseEvent e){
        if (e.getY() >= 320 && e.getY() <= 320 + 70){
            if (e.getX() >= 408 - 15 && e.getX() <= 408 - 15 + 135){
                return true;
            }
        }
        return false;
    }    


}
