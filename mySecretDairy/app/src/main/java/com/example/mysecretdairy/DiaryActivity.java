package com.example.mysecretdairy;

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

    // 메시지 큐 (First In First Out, 선입선출)
    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        diaryEditText = findViewById(R.id.diaryEditText);

        // 사용자가 이전에 적었던 일기를 불러와야 한다.
        SharedPreferences notePreferences = getSharedPreferences("diary", Context.MODE_PRIVATE);
        diaryEditText.setText(notePreferences.getString("detail", ""));

        // thread 기능 구현
        Runnable runnable = () -> {
            SharedPreferences preferences = getSharedPreferences("diary", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("detail", diaryEditText.getText().toString());
            editor.apply();
        };

        // 사용자가 한글자 한글자 입력할 때마다 이벤트 리스너를 등록해서 변경 사항을 가지고 오기
        diaryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("TAG", "char : " + s);
                Log.d("TAG", "start : " + start);
                Log.d("TAG", "count : " + count);
                Log.d("TAG", "after : " + after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 한글자 한글자 입력이 들어올때마다 저장할 예정

                // 여기에서 다른 스레드한테 일 해달라고 요청 함
                // a - 0.5초 delay - 삭제
                // ab - 0.5초 delay - 삭제
                // abc - 0.5초 delay - 삭제
                // abcd - 0.5초 delay 2초
                handler.removeCallbacks(runnable);
                // handler.post(runnable);
                handler.postDelayed(runnable, 500); // 한글자 쓰고 0.5초 기다렸다가 보내는 거

                Log.d("TAG", "char : " + s);
                Log.d("TAG", "i : " + start);
                Log.d("TAG", "before : " + before);
                Log.d("TAG", "count : " + count);

                // 새로운 쓰레드 만들어서 비동기 저장
                // 쓰레드 간 통신 - Handler 객체 사용하여 처리
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}