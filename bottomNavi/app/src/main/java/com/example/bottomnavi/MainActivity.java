package com.example.bottomnavi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.bottomnavi.utils.FragmentType;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomNavigation);

        addBottomNavigationListener();
        replaceFragment(FragmentType.HOME);
    }

    private void replaceFragment(FragmentType type) {
        // 프래그먼트 선언
        Fragment fragment;

        // 프래그먼트 매니저
        FragmentManager manager = getSupportFragmentManager();

        // 프래그먼트 트랜잭션
        FragmentTransaction transaction = manager.beginTransaction();

        if (type == FragmentType.HOME) {
            fragment = new FragmentHome();
        } else if (type == FragmentType.CHAT) {
            fragment = new FragmentChat();
        } else {
            fragment = new FragmentCal();
        }

        // 사용자가 버튼 눌렀을 때 생성되는 프래그먼트 할당 (메서드의 효용)
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }

    // 메서드 분리 (하나의 메서드는 하나의 책임을 진다)
    private void addBottomNavigationListener() {
        bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.page_home:
                    //프래그먼트 교체
                    replaceFragment(FragmentType.HOME);
                    Log.d("TAG", "홈 화면");
                    break;
                case R.id.chat:
                    //프래그먼트 교체
                    replaceFragment(FragmentType.CHAT);
                    Log.d("TAG", "채팅");
                    break;
                case R.id.calendar:
                    //프래그먼트 교체
                    replaceFragment(FragmentType.CAL);
                    Log.d("TAG", "캘린더");
                    break;
            }
            return true;
        });
    }
}