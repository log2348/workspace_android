package com.example.callbacktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    private OnButtonClicked onButtonClicked;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    public SubActivity(OnButtonClicked onButtonClicked) {
        this.onButtonClicked = onButtonClicked;
    }

    private void addEventListener() {

        button = findViewById(R.id.sendBtn);

        button.setOnClickListener(v -> {
            onButtonClicked.sendData();
        });

    }
}