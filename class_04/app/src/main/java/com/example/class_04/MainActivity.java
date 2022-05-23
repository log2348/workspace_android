package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String LIFE_CYCLE = "life_cycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 상속 객체의 onCreate() 메서드 호출
        super.onCreate(savedInstanceState);

        // 화면을 xml파일로 그려준다 (activity)
        // 처음에 화면을 그리는 것은 단 한번만 그려준다.
        setContentView(R.layout.activity_main);

        Log.d(LIFE_CYCLE, "onCreate ~ ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LIFE_CYCLE, "onStart ~");
    }

    /*
    @Override
    protected void onRestart() {
        super.onRestart();
    }
     */

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LIFE_CYCLE, "onResume ~");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LIFE_CYCLE, "onPause ~");
        // 홈 버튼 누르면 pause -> stop
        // 다시 들어가면 resume

        // 뒤로가기 버튼 누르면 pause -> stop
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LIFE_CYCLE, "onStop ~");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LIFE_CYCLE, "onDestroy ~");
    }
}