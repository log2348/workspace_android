package com.example.mybmi_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class BmiResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        if(getIntent() != null) {
            // 값 받기
            int height = getIntent().getIntExtra("height", 0);
            int weight = getIntent().getIntExtra("Weight", 0);

            // BMI - 체중 (kg) / 신장 * 신장 (m) (단위 주의)
            double bmiValue = weight / Math.pow(height / 100.0, 2); // pow - 제곱수
            Log.d("TAG", "bmi : " + bmiValue);
            String resultText = "";
            if(bmiValue < 18.5) {
                resultText = "저체중입니다.";
            } else if (bmiValue < 23) {
                resultText = "정상체중입니다.";
            }
        }
    }
}