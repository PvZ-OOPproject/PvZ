package GameState.LevelState;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Control.GamePanel;
import GUI_Game.PauseButton;
import GUI_Game.UrmButton;
import GameState.GameState;
import GameState.State;
import GameState.StateMethods;

public class Level extends State implements StateMethods{

    private UrmButton level_1, level_2,level_3;
    private UrmButton menu;
    private int level;

    public Level(GamePanel panel) {
        super(panel);
        
        createUrmButtons();
    }

    private void createUrmButtons(){
        level_1 = new UrmButton(96, 80 * 2,227, 318, "easy_button.png");
        level_2 = new UrmButton(419, 50 * 2,227, 318, "normal_button.png");
        level_3 = new UrmButton(743, 80 * 2,227, 318, "hard_button.png");
        menu = new UrmButton(438, 250 * 2,189, 33, "mainMenu_button.png");
    }

    @Override
    public void update() {
        level_1.update();
        level_2.update();
        level_3.update();
        menu.update();
    }

    @Override
    public void draw(GamePanel panel, Graphics2D g2D, Graphics g) {        
        g2D.drawImage(new ImageIcon("Image/GUI/level_bg.png").getImage(), 0, 0, null);
        
        level_1.draw(g);
        level_2.draw(g);
        level_3.draw(g);
        menu.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isIn(e,level_1)){
            level_1.setMousePressed(true);
        }
        else if (isIn(e,level_2)){
            level_2.setMousePressed(true);
        }
        else if (isIn(e,level_3)){
            level_3.setMousePressed(true);
        }
        else if (isIn(e,menu)){
            menu.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (isIn(e,level_1)){
            if (level_1.isMousePressed()){
                level = 1;
                setGameState(GameState.PLAYING);
            }
        }
        else if (isIn(e,level_2)){
            if (level_2.isMousePressed()){
                level = 2;
                setGameState(GameState.PLAYING);
            }
        }
        else if (isIn(e,level_3)){
            if (level_3.isMousePressed()){
                level = 3;
                setGameState(GameState.PLAYING);
            }
        }
        else if (isIn(e,menu)){
            if (menu.isMousePressed()){
                setGameState(GameState.MAIN_MENU);
            }
        }

        level_1.resetBools();
        level_2.resetBools();
        level_3.resetBools();
        menu.resetBools();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        level_1.setMouseOver(false);
        level_2.setMouseOver(false);
        level_3.setMouseOver(false);
        menu.setMouseOver(false);

        if (isIn(e,level_1))
            level_1.setMouseOver(true);
        else if (isIn(e,level_2))
            level_2.setMouseOver(true);
        else if (isIn(e,level_3))
            level_3.setMouseOver(true);
        else if (isIn(e,menu))
            menu.setMouseOver(true);

    }

    private boolean isIn(MouseEvent e, PauseButton b) {
		return b.getBounds().contains(e.getX(), e.getY());
	}

    public int getLevel(){
        return level;
    }

    public void setLevel(int num){
        this.level = num;
    }
}
