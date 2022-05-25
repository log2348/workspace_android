package com.example.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class BottomNavigation extends AppCompatActivity {

    private FragmentHome fragmentHome;
    private FragmentInfo fragmentInfo;

    private ImageView menuHome;
    private ImageView menuBoard;
    private ImageView menuLocation;
    private ImageView menuChat;
    private ImageView menuInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        menuHome = findViewById(R.id.home);
        menuBoard = findViewById(R.id.board);
        menuLocation = findViewById(R.id.location);
        menuChat = findViewById(R.id.chat);
        menuInfo = findViewById(R.id.info);

        // 프래그먼트 동적으로 만들기
        menuHome.setOnClickListener(view -> {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
        });

        menuInfo.setOnClickListener(view -> {
            fragmentInfo = new FragmentInfo();

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            transaction.replace(R.id.container, fragmentInfo);
            transaction.commit();

            Log.d("TAG", "내 정보 보기");

        });

    }
}