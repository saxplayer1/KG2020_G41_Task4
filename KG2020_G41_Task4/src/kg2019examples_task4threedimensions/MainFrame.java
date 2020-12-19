package kg2019examples_task4threedimensions;

import javax.swing.*;

public class MainFrame extends JFrame{
    private DrawPanel drawPanel1;
    private JPanel panel1;

    public MainFrame() {
        setSize(1000, 1000);
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
