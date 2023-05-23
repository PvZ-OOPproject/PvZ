package GameState.MainMenuState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.MouseEvent;

import Control.GamePanel;
import GUI_Game.PauseButton;
import GUI_Game.UrmButton;
import GameState.StateMethods;


public class Helps implements StateMethods{

    private boolean helpsState = false;
    private MainMenu mainMenu;

    private UrmButton ok_button;


    public Helps(MainMenu mainMenu){
        this.mainMenu = mainMenu;

        createUrmButtons();
    }

    private void createUrmButtons(){
        ok_button = new UrmButton((250 * 2), (200* 2), 189,33,"mainMenu_button.png");   
    }

    @Override
    public void update() {
        ok_button.update();
    }

    @Override
    public void draw(GamePanel panel, Graphics2D g2D, Graphics g) {
        if (helpsState){
            g2D.setColor(Color.gray);
            g2D.fillRect(100, 50, 866, 500);            

            ok_button.draw(g);;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isIn(e,ok_button)){
            ok_button.setMousePressed(true);
        }    
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (isIn(e,ok_button)){
            if (ok_button.isMousePressed()){
                mainMenu.setStopState(false);
                helpsState = false;
            }
        }

        ok_button.resetBools();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        ok_button.setMouseOver(false);

		if (isIn(e, ok_button))
			ok_button.setMouseOver(true);        
    }

    public boolean getHelpsState(){
        return helpsState;
    }

    public void setHelpsState(boolean active){
        this.helpsState = active;
    }

    private boolean isIn(MouseEvent e, PauseButton b) {
		return b.getBounds().contains(e.getX(), e.getY());
	}     
    
}
