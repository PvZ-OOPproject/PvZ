package Control;

import javax.swing.*;

public class GameFrame extends JFrame {
    
    GamePanel panel;

    JLayeredPane layeredPane;


    GameFrame(){

        panel = new GamePanel();
        /*int a = panel.PANEL_WIDTH;
        int b = panel.PANEL_HEIGHT;
        panel.setBounds(0, 0, a, b);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, a, b);

        JLabel label = new JLabel();
        label = new JLabel();

        String sunValue = String.valueOf(panel.getSunValue());
        label.setText(sunValue);
        label.setForeground(Color.black);
        label.setFont(new Font("MV Boli",Font.PLAIN,20));
        //label.setBackground();
        //label.setOpaque(false);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(15, 60, 55, 20);


        layeredPane.add(label,JLayeredPane.DRAG_LAYER);
        layeredPane.add(panel,JLayeredPane.DEFAULT_LAYER);*/
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set-up the sign "x" as exit
        //this.setSize(a,640);
        this.setResizable(true); // set ability to resize the frame
        this.setTitle("Plants Vs Zombies"); // set title of the frame
        
        //this.add(layeredPane);
        
        this.add(panel); // add panel into the frame
        
        this.pack(); // pack the size of the frame as the same as the size of the panel

        this.setLocationRelativeTo(null); //set frame in the center of the screen
        this.setVisible(true); //set visible of the frame
        this.setLayout(null);
    }

}
