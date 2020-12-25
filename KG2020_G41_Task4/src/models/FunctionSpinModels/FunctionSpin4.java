package models.FunctionSpinModels;

import kg2019examples_task4threedimensions.math.Vector3;
import kg2019examples_task4threedimensions.third.IModel;
import kg2019examples_task4threedimensions.third.PolyLine3D;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FunctionSpin4 implements IModel, IFunctionSpin{
    private Vector3 STX, ENDX;
    private float modY = 0.1f;
    private float modX = 0.1f;

    public FunctionSpin4(Vector3 STX, Vector3 ENDX) {
        this.STX = STX;
        this.ENDX = ENDX;
    }

    @Override
    public float countZ(float x, float y) {
        return (float) (Math.pow(x, 1 / 3) * Math.sin(y));
    }

    @Override
    public void setModX(float x) {
        this.modX = x;
    }

    @Override
    public void setModY(float y) {
        this.modY = y;
    }

    @Override
    public List<PolyLine3D> getLines() {
        LinkedList<PolyLine3D> lines = new LinkedList<>();

        for (float i = STX.getX(); i < ENDX.getX() - modX; i+= modX) {
            for (float j = STX.getY(); j < ENDX.getY() - modY; j+= modY) {
                lines.add(new PolyLine3D(Arrays.asList(new Vector3[]{
                        new Vector3(i, j, this.countZ(i, j)),
                        new Vector3(i + modX, j + modY, this.countZ(i + modX, j + modY)),
                        new Vector3(i + modX, j, this.countZ(i + modX, j)),
                        new Vector3(i, j + modX, this.countZ(i, j + modY))
                }),true));
            }
        }
        return lines;
    }
}
