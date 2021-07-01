package com.hotack.sensortest;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Author:
 * Date:
 * Description:
 */
public abstract class StepSensorBase implements SensorEventListener {
    private Context context;
    protected StepCallBack stepCallBack;
    protected SensorManager sensorManager;
    protected static int CURRENT_SETP = 0;
    protected boolean isAvailable = false;

    public StepSensorBase(Context context, StepCallBack stepCallBack) {
        this.context = context;
        this.stepCallBack = stepCallBack;
    }

    /**
     * 开启计步
     */
    public boolean registerStep() {
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            sensorManager = null;
        }
        sensorManager = SensorUtil.getInstance().getSensorManager(context);
        registerStepListener();
        return isAvailable;
    }

    public interface StepCallBack {
        void Step(int stepNum);
    }
    protected abstract void registerStepListener();
    public abstract void unregisterStep();
}
