package com.hotack.sensortest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SensorApplicatActivity extends AppCompatActivity implements View.OnClickListener{
    Button acceleApplicat;
    Button lightApplicat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_application);

        initView();
    }

    private void initView() {
        acceleApplicat = (Button) findViewById(R.id.acceleApplicat);
        acceleApplicat.setOnClickListener(this);

        lightApplicat = (Button) findViewById(R.id.lightApplicat);
        lightApplicat.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.acceleApplicat:
                Intent intent = new Intent(this,AccleApplicatActivity.class);
                startActivity(intent);
                break;
            case R.id.lightApplicat:
                break;
            default:
                break;
        }
    }
}