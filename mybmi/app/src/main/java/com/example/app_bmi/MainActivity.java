package com.example.app_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText weightText;
    private EditText heightText;
    private Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();
    }

    private void initData() {
        weightText = findViewById(R.id.weightTxt);
        heightText = findViewById(R.id.heightTxt);
        confirmBtn =  findViewById(R.id.confirmBtn);
    }

    private void addEventListener() {

        confirmBtn.setOnClickListener(view -> {
            // 값 넘겨주기
            String height = String.valueOf(heightText.getText());
            String weight = String.valueOf(weightText.getText());

            Intent intent = new Intent(this, BmiResultActivity.class);
            intent.putExtra("height", height);
            intent.putExtra("weight", weight);
            startActivity(intent);

        });

    }
}