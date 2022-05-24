package com.example.tool_bar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Button button = findViewById(R.id.btnFinish);
        int value1 = getIntent().getIntExtra("value", 0);
        Log.d("TAG", "value1 : " + value1);

        // 익명 구현 객체
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 값을 MainActivity로 보내기 (Intent)
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", value1 + 10);
                // 반드시 기억
                setResult(Activity.RESULT_OK, resultIntent);
                finish(); // 뒤로가기
            }
        });
    }
}