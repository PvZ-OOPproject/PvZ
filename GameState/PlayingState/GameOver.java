package GameState.PlayingState;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

import Control.GamePanel;
import GUI_Game.PauseButton;
import GUI_Game.UrmButton;
import GameState.StateMethods;
import GameState.GameState;

public class GameOver implements StateMethods{
    private boolean gameOverState = false;
    private Playing playing;
    private int gameOverDelay = 0;

    private UrmButton menuB,replayB;

    public GameOver(Playing playing){
        this.playing = playing;

        createUrmButtons();
    }

    private void createUrmButtons(){

        menuB = new UrmButton(580, 500, 189, 33,"mainMenu_button.png");
		replayB = new UrmButton(325, 500, 189, 33,"restartLevel_button.png");   
       
    }

    @Override
    public void update() {
        if (gameOverDelay <= 300)
            gameOverDelay++;

        menuB.update();
        replayB.update();
    }

    @Override
    public void draw(GamePanel panel, Graphics2D g2D, Graphics g) {
        if (gameOverState){
            if (gameOverDelay > 200){
            g2D.setColor(Color.black);
            g2D.fillRect(0, 0, 1066, 600);
            g2D.drawImage(new ImageIcon("Image/Others/game_over.jpg").getImage(),112,0,null);

            menuB.draw(g);
            replayB.draw(g);
            }
            else if (gameOverDelay >= 1 && gameOverDelay <= 200){
                g2D.drawImage(new ImageIcon("Image/Others/over.png").getImage(),251,66,null);
            }
        }   
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isIn(e, menuB))
            menuB.setMousePressed(true);
        else if (isIn(e, replayB))
            replayB.setMousePressed(true);
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (isIn(e, menuB)) {
            if (menuB.isMousePressed()) {
                playing.setGameState(GameState.MAIN_MENU);
                playing.reset();
                playing.getMainMenu().setCurState(0);
                playing.getLevel().setLevel(0);        
            }
        } 
        else if (isIn(e, replayB)){
            if (replayB.isMousePressed()) {
                playing.reset();
                playing.setPreparePlay(0);
            }
        }
        gameOverDelay = 0;
        menuB.resetBools();
        replayB.resetBools();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        menuB.setMouseOver(false);
        replayB.setMouseOver(false);

		if (isIn(e, menuB))
			menuB.setMouseOver(true);
		else if (isIn(e, replayB))
			replayB.setMouseOver(true);
  
    }

    public boolean getGameOverState(){
        return gameOverState;
    }

    public void setGameOverState(boolean active){
        this.gameOverState = active;
    }

    private boolean isIn(MouseEvent e, PauseButton b) {
		return b.getBounds().contains(e.getX(), e.getY());
	} 
}
