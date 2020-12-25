/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import kg2019examples_task4threedimensions.draw.IDrawer;
import kg2019examples_task4threedimensions.draw.SimpleEdgeDrawer;
import kg2019examples_task4threedimensions.math.Vector3;
import kg2019examples_task4threedimensions.screen.ScreenConverter;
import kg2019examples_task4threedimensions.third.Camera;
import kg2019examples_task4threedimensions.third.Scene;
import models.FactoryUtil.FunctionFactory;
import models.FunctionSpinModels.FunctionSpin1;

/**
 *
 * @author Alexey
 */
public class DrawPanel extends JPanel implements CameraController.RepaintListener {
    private Scene scene;
    private ScreenConverter sc;
    private Camera cam;
    private CameraController camController;
    private int curFunc = 1;
    private FunctionFactory factory = new FunctionFactory();
    private Vector3 STX= new Vector3(-2f, -2f, 0f);
    private Vector3 ENDX = new Vector3(2f, 2f, 0f);
    
    public DrawPanel() {
        super();
        factory.setT(curFunc);
        sc = new ScreenConverter(-1, 1, 2, 2, 1, 1);
        cam = new Camera();
        camController = new CameraController(cam, sc);
        scene = new Scene(Color.WHITE.getRGB());
        scene.showAxes();

        scene.getModelsList().add(factory.createFunction(STX, ENDX));
        
        camController.addRepaintListener(this);
        addMouseListener(camController);
        addMouseMotionListener(camController);
        addMouseWheelListener(camController);
    }
    
    @Override
    public void paint(Graphics g) {
        factory.setT(curFunc);
        scene.getModelsList().remove(0);
        scene.getModelsList().add(factory.createFunction(STX, ENDX));
        sc.setScreenSize(getWidth(), getHeight());
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D)bi.getGraphics();
        IDrawer dr = new SimpleEdgeDrawer(sc, graphics);
        scene.drawScene(dr, cam);
        g.drawImage(bi, 0, 0, null);
        graphics.dispose();
    }

    @Override
    public void shouldRepaint() {
        repaint();
    }

    public void setCurFunc(int curFunc) {
        this.curFunc = curFunc;
    }

    public int getCurFunc() {
        return curFunc;
    }

    public CameraController getCamController() {
        return camController;
    }
}
