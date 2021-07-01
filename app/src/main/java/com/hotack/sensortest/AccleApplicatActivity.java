package com.hotack.sensortest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AccleApplicatActivity extends AppCompatActivity implements StepSensorBase.StepCallBack{
    private SensorManager mSensorManager;
    TextView stepText;
    private StepSensorAcceleration mStepSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accle_applicat);

        stepText = (TextView) findViewById(R.id.step_text);
        mStepSensor = new StepSensorAcceleration(this,this);
        if(!mStepSensor.registerStep()) {
            Toast.makeText(this, "加速度传感器不可用",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void Step(int stepNum) {
        stepText.setText("步数:" + stepNum);
    }
}