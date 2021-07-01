package com.hotack.sensortest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button getSensorData;
    Button sensorApplicat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        getSensorData = (Button) findViewById(R.id.sensorDataInfo);
        getSensorData.setOnClickListener(this);

        sensorApplicat = (Button) findViewById(R.id.sensorApplicat);
        sensorApplicat.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sensorDataInfo:
                startGetSensorDataActivity();
                break;
            case R.id.sensorApplicat:
                startSensorApplicatActivity();
            default:
                break;
        }
    }

    private void startGetSensorDataActivity() {
        Intent intent = new Intent(this, SensorCollectAvtivity.class);
        startActivity(intent);
    }

    private void startSensorApplicatActivity() {
        Intent intent = new Intent(this, SensorApplicatActivity.class);
        startActivity(intent);
    }
}