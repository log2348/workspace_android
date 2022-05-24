package com.example.app_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout weightText;
    private TextInputLayout heightText;
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
            Editable heightEditable = heightText.getEditText().getText();
            Editable weightEditable = weightText.getEditText().getText();

            if(heightEditable.length() < 1 || weightEditable.length() < 1) {
                Toast.makeText(this, "빈 칸이 있습니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int height = Integer.parseInt(heightEditable.toString());
                int weight = Integer.parseInt(weightEditable.toString());

                // 값 넘겨주기
                Intent intent = new Intent(this, BmiResultActivity.class);
                intent.putExtra("height", height);
                intent.putExtra("weight", weight);
                startActivity(intent);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "잘못 입력하셨습니다.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}