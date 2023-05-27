package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class LaunchPage implements ActionListener{
    
    JFrame frame = new JFrame();
    JButton myButton1 = new JButton("Click to start");
    JButton myButton2 = new JButton("Quit");

    public LaunchPage(){
    

        myButton1.setBounds(100, 160, 200, 40);

        myButton1.setFocusable(false);
        myButton1.addActionListener(this);

        myButton2.setBounds(500, 160, 200, 40);
        myButton2.setFocusable(false);
        myButton2.addActionListener(this);       

        frame.add(myButton1);
        frame.add(myButton2);

        frame.setResizable(true);
        frame.setTitle("Plants Vs Zombies");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1066,600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myButton1){
            frame.dispose();
            new GameFrame();
        }
        if (e.getSource() == myButton2){
            frame.dispose();
        }
    }
}