package GameState;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import Control.GamePanel;

public interface StateMethods {
	public void update();

	public void draw(GamePanel panel,Graphics2D g2D,Graphics g);

	public void mouseClicked(MouseEvent e);

	public void mousePressed(MouseEvent e);

	public void mouseReleased(MouseEvent e);

	public void mouseMoved(MouseEvent e);
  
}
