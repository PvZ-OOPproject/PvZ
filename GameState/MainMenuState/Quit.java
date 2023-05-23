package GameState.MainMenuState;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Control.GamePanel;
import GUI_Game.PauseButton;
import GUI_Game.UrmButton;
import GameState.StateMethods;

public class Quit implements StateMethods{

    private boolean quitState = false;
    private MainMenu mainMenu;
    private UrmButton cancel_button,leave_button;

    public Quit (MainMenu mainMenu){
        this.mainMenu = mainMenu;
        
        createUrmButtons();
    }

    private void createUrmButtons(){

        leave_button = new UrmButton(370,400, 163, 45,"leave.png");
        cancel_button = new UrmButton(540,400, 163, 45,"cancel.png");
    }

    @Override
    public void update() {
        leave_button.update();
        cancel_button.update();
    }

    @Override
    public void draw(GamePanel panel, Graphics2D g2D, Graphics g) {
        if (quitState){
            g.drawImage(new ImageIcon("Image/GUI/leavegame.png").getImage(), 333, 140, null);

            leave_button.draw(g);
            cancel_button.draw(g);
        }    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isIn(e,leave_button)){
            leave_button.setMousePressed(true);
        }
        else if (isIn(e,cancel_button)){
            cancel_button.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (isIn(e,leave_button)){
            if (leave_button.isMousePressed()){
                System.exit(0);
            }
        }
        else if (isIn(e,cancel_button)){
            if (cancel_button.isMousePressed()){
                quitState = false;
                mainMenu.setStopState(false);
            }
        }

        leave_button.resetBools();
        cancel_button.resetBools();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        leave_button.setMouseOver(false);
        cancel_button.setMouseOver(false);

		if (isIn(e, leave_button))
			leave_button.setMouseOver(true);
		if (isIn(e, cancel_button))
			cancel_button.setMouseOver(true);  
    }

    public boolean getQuitState(){
        return quitState;
    }

    public void setQuitState(boolean active){
        this.quitState = active;
    }

    private boolean isIn(MouseEvent e, PauseButton b) {
		return b.getBounds().contains(e.getX(), e.getY());
	} 
}