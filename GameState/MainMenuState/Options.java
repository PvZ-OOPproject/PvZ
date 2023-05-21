package GameState.MainMenuState;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Control.GamePanel;
import GUI_Game.AudioOptions;
import GUI_Game.PauseButton;
import GUI_Game.UrmButton;
import GameState.StateMethods;

public class Options implements StateMethods{
    private boolean optionsState = false;

    private AudioOptions audioOptions;
    private MainMenu mainMenu;

    private UrmButton ok_button;

    public Options(MainMenu mainMenu){
        this.mainMenu = mainMenu;
        this.audioOptions = mainMenu.getGamePanel().getAudioOptions();

        createUrmButtons();
    }

    private void createUrmButtons(){

        ok_button = new UrmButton((int) (188.5 * 2), (208* 2), 314,72,"backToGame_button.png");
    }

    @Override
    public void update() {
            ok_button.update();
            audioOptions.update();
    }

    @Override
    public void draw(GamePanel panel, Graphics2D g2D, Graphics g) {
        if (optionsState){
            g2D.drawImage(new ImageIcon("Image/GUI/menu.png").getImage(),333,50, null);
            
            ok_button.draw(g);
            audioOptions.draw(g);
        }
    }

    public void mouseDragged(MouseEvent e){
        audioOptions.mouseDragged(e);
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
        else {
            audioOptions.mousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (isIn(e,ok_button)){
            if (ok_button.isMousePressed()){
                optionsState = false;
                mainMenu.setStopState(false);
            }
        }
        else {
            audioOptions.mouseReleased(e);
        }

        ok_button.resetBools();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        ok_button.setMouseOver(false);
        

        if (isIn(e,ok_button))
            ok_button.setMouseOver(true);
        else
            audioOptions.mouseMoved(e);
        
    }

    private boolean isIn(MouseEvent e, PauseButton b) {
		return b.getBounds().contains(e.getX(), e.getY());
	}

    public boolean getOptionsState(){
        return optionsState;
    }

    public void setOptionsState(boolean active){
        this.optionsState = active;
    }
    
}
