package com.example.app_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {

    private TextView bmiResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        bmiResult = findViewById(R.id.bmiText);
    }
}