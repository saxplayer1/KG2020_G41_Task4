package models;

import kg2019examples_task4threedimensions.math.Vector3;
import kg2019examples_task4threedimensions.third.IModel;
import kg2019examples_task4threedimensions.third.PolyLine3D;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FunctionSpin implements IModel {
    private Vector3 STX, ENDX;

    public FunctionSpin(Vector3 STX, Vector3 ENDX) {
        this.STX = STX;
        this.ENDX = ENDX;
    }

    private static float countZ(float x, float y) {
        return(x * x + y * y);
    }

    @Override
    public List<PolyLine3D> getLines() {
        float mod = 0.1f;
        LinkedList<PolyLine3D> lines = new LinkedList<>();

        for (float i = STX.getX(); i < ENDX.getX() - mod; i+= mod) {
            for (float j = STX.getY(); j < ENDX.getY() - mod; j+= mod) {
                lines.add(new PolyLine3D(Arrays.asList(new Vector3[]{
                        new Vector3(i, j, countZ(i, j)),
                        new Vector3(i + mod, j + mod, countZ(i + mod, j + mod)),
                        new Vector3(i + mod, j, countZ(i + mod, j)),
                        new Vector3(i, j + mod, countZ(i, j + mod))
                }),true));
            }
        }
        return lines;
    }
}
