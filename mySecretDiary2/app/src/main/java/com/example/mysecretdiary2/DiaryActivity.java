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

    EditText diaryEditText;
    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        diaryEditText = findViewById(R.id.daiaryEditText);

        SharedPreferences notePreferences = getSharedPreferences("diary", MODE_PRIVATE);
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
                // 한 글자 입력되기 직전 정보

                Log.d("beforeTextChanged", "char : " + s);
                Log.d("beforeTextChanged", "start : " + start);
                Log.d("beforeTextChanged", "count : " + count);
                Log.d("beforeTextChanged", "after : " + after);
                Log.d("beforeTextChanged", "");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 한 글자 입력되는 순간간

                Log.d("onTextChanged", "char : " + s); // 입력 문자
                Log.d("onTextChanged", "start : " + start);
                Log.d("onTextChanged", "before : " + before); // 그 전 글자 수
                Log.d("onTextChanged", "count : " + count); // 입력된 글자 수
                Log.d("onTextChanged", "");

                //handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 500);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}