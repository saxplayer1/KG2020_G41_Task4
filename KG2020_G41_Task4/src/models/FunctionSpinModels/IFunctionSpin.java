package models.FunctionSpinModels;

import kg2019examples_task4threedimensions.third.IModel;

public interface IFunctionSpin extends IModel {
    float countZ(float x, float y);

    void setModX(float x);
    void setModY(float y);
}
