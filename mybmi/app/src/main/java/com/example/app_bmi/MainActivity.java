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
        weightText = findViewById(R.id.weightText);
        heightText = findViewById(R.id.heightText);
        confirmBtn =  findViewById(R.id.confirmBtn);
    }

    private void addEventListener() {
        String weight = weightText.getText().toString();
        Intent intent = new Intent(this, BmiResultActivity.class);
        intent.putExtra("weight", weight);
        startActivity(intent);
    }
}