package com.example.app_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    private TextView bmiText;
    private TextView bmiResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        returnBmi();
    }

    private void returnBmi() {

        bmiText = findViewById(R.id.bmi);
        bmiResultText = findViewById(R.id.resultText);

        if (getIntent() != null) {

            // 값 받기
            int height = getIntent().getIntExtra("height", 0);
            int weight = getIntent().getIntExtra("weight", 0);

            double bmi = weight / Math.pow(height / 100.0, 2);
            double formatBmi = Double.parseDouble(String.format("%.2f", bmi)); // 소수 첫째 자리까지 표현
            String resultText = "";

            Log.d(TAG, "bmi : " + bmi);

            if (formatBmi < 18.5) {
                resultText = "저체중";
                bmiResultText.setTextColor(Color.YELLOW);
                Log.d(TAG, "resultText : " + resultText);
            } else if (formatBmi > 18.6 && formatBmi < 24.9) {
                resultText = "표준";
                bmiResultText.setTextColor(Color.GREEN);
                Log.d(TAG, "resultText : " + resultText);
            } else if (formatBmi > 23.0 && formatBmi < 24.9) {
                resultText = "과체중";
                bmiResultText.setTextColor(Color.YELLOW);
                Log.d(TAG, "resultText : " + resultText);
            } else if (formatBmi > 25.0 && formatBmi < 29.9) {
                resultText = "중도비만";
                bmiResultText.setTextColor(Color.RED);
                Log.d(TAG, "resultText : " + resultText);
            } else {
                resultText = "고도비만";
                bmiResultText.setTextColor(Color.RED);
                Log.d(TAG, "resultText : " + resultText);
            }
            bmiText.setText(String.valueOf(formatBmi));
            bmiResultText.setText(resultText);
        }
    }

}