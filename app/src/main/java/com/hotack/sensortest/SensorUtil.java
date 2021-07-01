package com.hotack.sensortest;

import android.content.Context;
import android.hardware.SensorManager;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Author:
 * Date:
 * Description:
 */
public class SensorUtil {
    private SensorUtil(){
    }

    //创建私有静态实例，意味着这个类第一次使用时，这个实例就会创建
    private static SensorUtil instance = new SensorUtil();

    public static SensorUtil getInstance() {
        return instance;
    }

    public SensorManager getSensorManager(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService(SENSOR_SERVICE);
        return sensorManager;
    }
}
