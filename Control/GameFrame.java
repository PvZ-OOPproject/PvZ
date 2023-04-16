package Control;

import javax.swing.*;

public class GameFrame extends JFrame {
    
    GamePanel panel;


    GameFrame(){

        panel = new GamePanel();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set-up the sign "x" as exit
        //this.setSize(2500,600);
        this.setResizable(false); 
        this.setTitle("Plants Vs Zombies");
        
        this.add(panel);
        
        this.pack();

        this.setLocationRelativeTo(null); //set frame in the center of the screen
        this.setVisible(true); //set visible of the frame

    }

}
