package com.example.app_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    private TextView bmiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        returnBmi();
    }

    private void returnBmi() {

        bmiResult = findViewById(R.id.bmi);

        if(getIntent() != null) {

            // 값 받기
            int height = getIntent().getIntExtra("height", 0);
            int weight = getIntent().getIntExtra("weight", 0);

            double bmi = weight / Math.pow(height / 100.0, 2);
            String resultText = "";

            Log.d(TAG, "bmi : " + bmi);

            if(bmi < 18.5) {
                resultText = "저체중";
            } else if(bmi > 18.6 && bmi < 24.9) {
                resultText = "표준";
            } else if(bmi > 23.0 && bmi < 24.9) {
                resultText = "과체중";
            } else if(bmi > 25.0 && bmi < 29.9) {
                resultText = "중도비만";
            } else {
                resultText = "고도비만";
            }

            bmiResult.setText(resultText);
        }
    }

}