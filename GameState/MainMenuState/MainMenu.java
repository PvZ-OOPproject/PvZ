package GameState.MainMenuState;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Control.GamePanel;

import GUI_Game.PauseButton;
import GUI_Game.UrmButton;
import GameState.State;
import GameState.GameState;
import GameState.StateMethods;
import GameState.LevelState.Level;

public class MainMenu extends State implements StateMethods {
    private Quit quit;
    private Helps helps;
    private Options options;

    private UrmButton playing_button, options_button, helps_button, quit_button;

    private boolean stopState = false;

    private int currentState = 0;
    private Level level;
    private GamePanel panel;

    //private MenuButton[] buttons = new MenuButton[3];

    public MainMenu(GamePanel panel,Level level){
        super(panel);
        this.panel = panel;
        quit = new Quit(this);
        options = new Options(this);
        helps = new Helps(this);

        this.level = level;

        loadButtons();
    }



    @Override
    public void update() {
		//for (MenuButton mb : buttons)
		//	mb.update();
        if (!stopState){
            playing_button.update();
            options_button.update();
            quit_button.update();
            helps_button.update();
        }
        if (options.getOptionsState()){
            options.update();
        }
        if (quit.getQuitState()){
            quit.update();
        }
        if (helps.getHelpsState()){
            helps.update();
        }
        

    }


    @Override
    public void draw(GamePanel panel, Graphics2D g2D, Graphics g) {
        
        g2D.drawImage(new ImageIcon("Image/GUI/mainmenu.png").getImage(), 0, 0, 1066, 600, null);

        playing_button.draw(g);
        options_button.draw(g);
        quit_button.draw(g);
        helps_button.draw(g);

        quit.draw(panel, g2D,g);
        options.draw(panel, g2D, g);
        helps.draw(panel, g2D, g);
        
        //g2D.setColor(Color.BLUE);
        //g2D.fillRect(700, 200, 200, 250);
        //g2D.fillRect(400, 200, 200, 250);
        //g2D.fillRect(100, 200, 200, 250);

    }

    public void mouseDragged(MouseEvent e){
        if (options.getOptionsState()){
            options.mouseDragged(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }


    @Override
    public void mousePressed(MouseEvent e) {
		//for (MenuButton mb : buttons) {
		//	if (isIn(e, mb)) {
		//		mb.setMousePressed(true);
		//	}
		//}
        if (!stopState){
            if (isIn(e, playing_button)){
                playing_button.setMousePressed(true);
            }
            else if (isIn(e, options_button)){
                options_button.setMousePressed(true);
            }
            else if (isIn(e,quit_button)){
                quit_button.setMousePressed(true);
            }
            else if (isIn(e,helps_button)){
                helps_button.setMousePressed(true);
            }
        }
        if (options.getOptionsState()){
            options.mousePressed(e);
        }
        if (quit.getQuitState()){
            quit.mousePressed(e);
        }
        if (helps.getHelpsState()){
            helps.mousePressed(e);
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {
		/*for (MenuButton mb : buttons) {
			if (isIn(e, mb)) {
				if (mb.isMousePressed())
					//mb.applyGameState();
				//if (mb.getState() == GameState.PLAYING){

                //}
				break;
			}
		}

		resetButtons();*/
        if (!stopState){
            if (isIn(e, playing_button)){
                if (playing_button.isMousePressed()){
                    if (currentState == level.getLevel())
                        setGameState(GameState.LEVEL);
                    else{
                        panel.getAudioPlayer().playSong(1);
                        setGameState(GameState.PLAYING);
                    }
                }
            }
            else if (isIn(e, options_button)){
                if (options_button.isMousePressed()){
                    stopState = true;
                    options.setOptionsState(true);
                }
            }
            else if (isIn(e, quit_button)){
                if (quit_button.isMousePressed()){
                    stopState = true;
                    quit.setQuitState(true);
                }
            }
            else if (isIn(e, helps_button)){
                if (helps_button.isMousePressed()){
                    stopState = true;
                    helps.setHelpsState(true);
                }
            }
            
            playing_button.resetBools();
            options_button.resetBools();
            quit_button.resetBools();
            helps_button.resetBools();
        }
        if (options.getOptionsState()){
            options.mouseReleased(e);
        }
        if (quit.getQuitState()){
            quit.mouseReleased(e);
        }
        if (helps.getHelpsState()){
            helps.mouseReleased(e);
        }
    }

    /*private void resetButtons() {
		for (MenuButton mb : buttons)
			mb.resetBools();

	}*/


    @Override
    public void mouseMoved(MouseEvent e) {
		/*for (MenuButton mb : buttons)
			mb.setMouseOver(false);

		for (MenuButton mb : buttons)
			if (isIn(e, mb)) {
				mb.setMouseOver(true);
				break;
			}
        */
        if (!stopState){
            playing_button.setMouseOver(false);
            options_button.setMouseOver(false);
            quit_button.setMouseOver(false);
            helps_button.setMouseOver(false);

            if (isIn(e, playing_button)){
                playing_button.setMouseOver(true);
            }
            else if (isIn(e, options_button)){
                options_button.setMouseOver(true);
            }
            else if (isIn(e, quit_button)){
                quit_button.setMouseOver(true);
            }
            else if (isIn(e, helps_button)){
                helps_button.setMouseOver(true);
            }
        }

        if (options.getOptionsState()){
            options.mouseMoved(e);
        }
        if (quit.getQuitState()){
            quit.mouseMoved(e);
        }
        if (helps.getHelpsState()){
            helps.mouseMoved(e);
        }
    }

    private void loadButtons() {
		playing_button = new UrmButton(390, 200,285,69,"start_button.png");//,GameState.PLAYING);
		options_button = new UrmButton(390, 285,285,69,"options_button.png");//,GameState.OPTIONS);
		quit_button = new UrmButton(390, 455,285,69,"quit_button.png");//,GameState.QUIT);
        helps_button = new UrmButton(390, 370,285,69,"helps_button.png");//,GameState.QUIT);
	}


    private boolean isIn(MouseEvent e, PauseButton b) {
		return b.getBounds().contains(e.getX(), e.getY());
	}

    public void setStopState(boolean active){
        this.stopState = active;
    }

    public boolean getStopState(){
        return stopState;
    }

    public int getCurState(){
        return currentState;
    }

    public void setCurState(int num){
        this.currentState = num;
    }


}
