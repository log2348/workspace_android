package com.example.movie_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // status bar 없애기
        // Window - activity 감싸고 있는 객체
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        TextView textView = findViewById(R.id.splashTextView);
        // 애니메이션
        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_side);
        textView.startAnimation(slideAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                // SplashActivity --> MainActivity
                finish(); // SplashActivity 내려버림
                // MainActivity
            }
        }, 1500); // 1.5초 딜레이
    }
}