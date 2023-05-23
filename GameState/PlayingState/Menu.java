package GameState.PlayingState;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Control.GamePanel;
import GUI_Game.AudioOptions;
import GUI_Game.PauseButton;
import GUI_Game.UrmButton;
import GameState.StateMethods;
import GameState.GameState;

public class Menu implements StateMethods{
    
    private boolean menuState = false;
    private Playing playing;

    private AudioOptions audioOptions;

    private UrmButton backToGame, mainMenu, restart, quit;


    public Menu(Playing playing){
        this.playing = playing;
        

        this.audioOptions = playing.getGamePanel().getAudioOptions();
        
        createUrmButtons();
    }

    private void createUrmButtons(){
        quit = new UrmButton(219 * 2, 138 * 2, 192, 33,"quit.png");
        mainMenu = new UrmButton(220 * 2, 178 * 2, 189, 33,"mainMenu_button.png");
		restart = new UrmButton(220 * 2, 158 * 2, 189, 33,"restartLevel_button.png");
        backToGame = new UrmButton((int) 188.5 * 2, 208 * 2, 314, 72,"backToGame_button.png");
    }

    @Override
    public void update() {
        quit.update();
        mainMenu.update();
		restart.update();
        backToGame.update();


        audioOptions.update();
    }

    @Override
    public void draw(GamePanel panel, Graphics2D g2D, Graphics g) {
        if (menuState){
            g2D.drawImage(new ImageIcon("Image/GUI/menu.png").getImage(),333,50, null);

        quit.draw(g);
        mainMenu.draw(g);
        restart.draw(g);
        backToGame.draw(g);

        audioOptions.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e){
        audioOptions.mouseDragged(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isIn(e, mainMenu))
            mainMenu.setMousePressed(true);
        else if (isIn(e, quit))
            quit.setMousePressed(true);
        else if (isIn(e, restart))
            restart.setMousePressed(true);
        else if (isIn(e, backToGame))
            backToGame.setMousePressed(true);             
        else
            audioOptions.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (isIn(e, mainMenu)) {
            if (mainMenu.isMousePressed()) {
                playing.setGameState(GameState.MAIN_MENU);
                menuState = false;
                //playing.reset();
                playing.setStopState(false);
                playing.getMainMenu().setCurState(0);                
            }
        }
        if (isIn(e,quit)){
            if (quit.isMousePressed()){
                playing.setGameState(GameState.MAIN_MENU);
                playing.reset();
                playing.getMainMenu().setCurState(0);
                playing.getLevel().setLevel(0);
            }
        }
        else if (isIn(e, restart)) {
            if (restart.isMousePressed()) {
                playing.reset();
                playing.setStopState(true);
                playing.setPreparePlay(0);
            }
        } 
        else if (isIn(e, backToGame)) {
            if (backToGame.isMousePressed()){
                menuState = false;
                playing.setStopState(false);
            }
        } 
        else{
            audioOptions.mouseReleased(e);
        }

        quit.resetBools();
        mainMenu.resetBools();
        restart.resetBools();
        backToGame.resetBools();


    }
    

    @Override
    public void mouseMoved(MouseEvent e) {
        quit.setMouseOver(false);
        mainMenu.setMouseOver(false);
        restart.setMouseOver(false);
        backToGame.setMouseOver(false);

		if (isIn(e, mainMenu))
			mainMenu.setMouseOver(true);
        else if (isIn(e, quit))
			quit.setMouseOver(true);
		else if (isIn(e, restart))
			restart.setMouseOver(true);
		else if (isIn(e, backToGame))
			backToGame.setMouseOver(true);
		else
			audioOptions.mouseMoved(e);
        
    }

    public boolean getMenuState(){
        return menuState;
    }

    public void setMenuState(boolean active){
        this.menuState = active;
    }
    
    private boolean isIn(MouseEvent e, PauseButton b) {
		return b.getBounds().contains(e.getX(), e.getY());
	}    
}
