package models.FactoryUtil;

import kg2019examples_task4threedimensions.math.Vector3;
import models.FunctionSpinModels.*;

public class FunctionFactory {
    private int type = 1;

    public IFunctionSpin createFunction(Vector3 STX, Vector3 ENDX) {
        switch (type) {
            case 1:
                return new FunctionSpin1(STX, ENDX);
            case 2:
                return new FunctionSpin2(STX, ENDX);
            case 3:
                return new FunctionSpin3(STX, ENDX);
            case 4:
                return new FunctionSpin4(STX, ENDX);
        }
        return null;
    }

    public int getT() {
        return type;
    }

    public void setT(int t) {
        this.type = t;
    }
}
