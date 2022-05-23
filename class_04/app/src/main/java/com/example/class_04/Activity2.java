package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView text1;
    private TextView text2;
    private TextView text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        TextView textView = findViewById(R.id.nameTextView);

        // 값을 받는 방법
        // 값이 없다면 기본 값을 0으로 셋팅
        // 방어적 코드
        if(getIntent() != null) {
            String getData = getIntent().getStringExtra(Activity1.KEY_NAME);
            textView.setText(getData);
        }

    }
}