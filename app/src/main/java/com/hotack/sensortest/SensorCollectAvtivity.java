package com.hotack.sensortest;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.util.Locale;

public class SensorCollectAvtivity extends AppCompatActivity{
    private static final String TAG = "huling";

    private SensorManager mSensorManager;
    private MySensorEventListener mMySensorEventListener;
    private Sensor Sensor_Accele;
    private Sensor Sensor_Light;

    private Handler mHandler;

    TextView accTypeView;
    TextView accDataView;
    TextView lightTypeView;
    TextView lightDataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensordatainfo);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor_Accele = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor_Light = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        mMySensorEventListener = new MySensorEventListener();

        initView();
    }

    private void initView() {
        //Accele type
        accTypeView = (TextView) findViewById(R.id.accTypeView);
        accTypeView.setBackgroundColor(0xFF00FF00);     //green color
        if(Sensor_Accele != null) {
            accTypeView.setText(" ACCE: " + Sensor_Accele.getName());
        } else {
            accTypeView.setText(" ACCE: No Accelerometer detected");
        }
        //Accele data
        accDataView = (TextView) findViewById(R.id.accDataView);
//----------------------------------------------------------------------------
        //Light type
        lightTypeView = (TextView) findViewById(R.id.lightTypeView);
        lightTypeView.setBackgroundColor(0xFF00FF00);     //green color
        if(Sensor_Light != null) {
            lightTypeView.setText(" ACCE: " + Sensor_Light.getName());
        } else {
            lightTypeView.setText(" LIGHT: No light sensor detected");
        }
        //Light data
        lightDataView = (TextView) findViewById(R.id.lightDataView);
    }


    @Override
    protected void onResume() {
        super.onResume();
        sensorListenerRegister();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mMySensorEventListener);
    }

    //注册sensor监听器
    private void sensorListenerRegister() {
        mSensorManager.registerListener(mMySensorEventListener, Sensor_Accele, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(mMySensorEventListener, Sensor_Light, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private class MySensorEventListener implements SensorEventListener {
        //sensor的采集数据的精度发生变化时，会执行onAccuracyChanged
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        //sensor的采集数据发生变化时，会执行onSensorChanged
        public void onSensorChanged(SensorEvent event) {
            int mSensorType = event.sensor.getType();
            //加速度传感器
            if(mSensorType == Sensor.TYPE_ACCELEROMETER) {
                float[] Acc_Data = event.values;
                //数据
                String fmt_Acc_Data = String.format(Locale.US,"\tAcc(X): \t%10.5f \tm/s^2\n\tAcc(Y): \t%10.5f \tm/s^2\n\tAcc(Z): \t%10.5f \tm/s^2\n\tFreq:  Hz",
                        Acc_Data[0], Acc_Data[1], Acc_Data[2] /*, 50*/);
                accDataView.setText(fmt_Acc_Data);

                //采样率
            }

            if(mSensorType == Sensor.TYPE_LIGHT) {
                float[] light_data = event.values;
                String fmt_light_data = String.format(Locale.US,"\tLight Intensity: \t%8.1f \tLux\n\tFreq:   Hz",light_data[0]);
                lightDataView.setText(fmt_light_data);
            }
        }
    }
}