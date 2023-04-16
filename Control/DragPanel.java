package Control;
import java.awt.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
public class DragPanel extends JPanel{
    ImageIcon image = new ImageIcon("zombie_normal.gif");
    final int WIDTH = image.getIconWidth();
    final int HEIGHT = image.getIconHeight();
    Point imageCorner;
    Point prePt;
    
    public DragPanel(){
        imageCorner = new Point(0,0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
    }
    public void paint(Graphics g){
        super.paint(g);
        image.paintIcon(this, g,(int) imageCorner.getX(),(int)imageCorner.getY());
        
    }
    public class ClickListener extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            prePt = e.getPoint();   
        }
    }
    public class DragListener extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent e){
            Point currentPt = e.getPoint();
            imageCorner.translate((int)(currentPt.getX()-prePt.getX()),(int)(currentPt.getY()-prePt.getY()));
            prePt = currentPt;
            repaint();
        }
    }
}
