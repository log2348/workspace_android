package com.example.mysecretdiary2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class DiaryActivity extends AppCompatActivity {

    private EditText diaryEditText;

    // 메인 쓰레드에 연결될 핸들러 생성
    // 외부 쓰레드로 받은 메시지를 메인 쓰레드의 메시지 큐로 전달
    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        diaryEditText = findViewById(R.id.dairyEditText);

        SharedPreferences notePreferences = getSharedPreferences("diary", MODE_PRIVATE);

        // SharedPreferences에 저장되어 있는 글을 diaryEditText에 불러옴
        diaryEditText.setText(notePreferences.getString("detail", ""));

        Runnable runnable = () -> {
            SharedPreferences preferences = getSharedPreferences("diary", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("detail", diaryEditText.getText().toString());
            editor.apply();
        };

        diaryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 한 글자 입력되기 직전 호출
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 글자 입력되는 순간마다 호출된다

                // 실행되지 않고 지연되고 있는 runnable이 있다면 지워준다
                handler.removeCallbacks(runnable);

                // 핸들러를 이용하여 0.5초마다 runnable을 실행하도록
                handler.postDelayed(runnable, 500);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}