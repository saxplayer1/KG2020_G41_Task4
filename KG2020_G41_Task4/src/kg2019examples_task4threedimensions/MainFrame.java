package kg2019examples_task4threedimensions;

import kg2019examples_task4threedimensions.math.Matrix4Factories;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private DrawPanel mainPanel;
    private JPanel panel1;
    private JButton nextFuncButton;
    private JTextField rotationPeriodTF;
    private JButton prevFuncButton;
    private JButton rotateButton;
    private JButton switchAxisButton;
    private boolean rotating = false;
    private Matrix4Factories.Axis chosenAxis = Matrix4Factories.Axis.X;
    private Timer timer;

    public MainFrame() {
        setSize(1000, 1000);
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rotate();
            }
        });

        nextFuncButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cur = mainPanel.getCurFunc();
                if (cur == 4) {
                    mainPanel.setCurFunc(1);
                } else {
                    mainPanel.setCurFunc(cur + 1);
                }
                mainPanel.repaint();
            }
        });

        prevFuncButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cur = mainPanel.getCurFunc();
                if (cur == 1) {
                    mainPanel.setCurFunc(4);
                } else {
                    mainPanel.setCurFunc(cur - 1);
                }
                mainPanel.repaint();
            }
        });

        rotateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer.isRunning()) {
                    timer.stop();
                    rotateButton.setText("Rotate!");
                } else {
                    timer.start();
                    rotateButton.setText("Stop!");
                }
            }
        });

        switchAxisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switch(chosenAxis) {
                    case X: {
                        chosenAxis = Matrix4Factories.Axis.Y;
                        switchAxisButton.setText("Chosen axis is Y");
                        break;
                    }
                    case Y: {
                        chosenAxis = Matrix4Factories.Axis.Z;
                        switchAxisButton.setText("Chosen axis is Z");
                        break;
                    }
                    case Z: {
                        chosenAxis = Matrix4Factories.Axis.X;
                        switchAxisButton.setText("Chosen axis is X");
                        break;
                    }
                }
            }
        });
    }

    private void rotate() {
        int period = Integer.parseInt(rotationPeriodTF.getText());
        mainPanel.getCamController().getCamera().modifyRotate(Matrix4Factories.rotationXYZ(Math.PI * period / 400, chosenAxis));
        repaint();
    }
}
