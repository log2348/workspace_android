package com.example.tablayout_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.tablayout_page.adapter.MyPagerAdapter;
import com.google.android.material.tabs.TabLayout;

/*
    pager
    - 화면 (종이 넘기듯이 화면을 넘겨 주는 역할)
    - Adapter 필요

    TabLayout
    - tab 을 담당하는 역할
    - 보통 같이 작성을 하지만 따로 따로 만들어도 상관이 없다.

    리스너
    pager와 TabLayout을 연결해주기 위해 필요하다.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    public static final int TAB_COUNT = 3;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();
    }

    private void initData() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), TAB_COUNT);

        // 동적 생성
        tabLayout.addTab(tabLayout.newTab().setText("ONE"));
        tabLayout.addTab(tabLayout.newTab().setText("TWO"));
        tabLayout.addTab(tabLayout.newTab().setText("THREE"));

        viewPager.setAdapter(myPagerAdapter);

        // 뷰 페이저와 Tab 연동
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void addEventListener() {
        // 1번 탭에서 2번 탭으로 진행 됐을 때 (1번탭 사라질 때 뭔가 해야 할 일이 있다면)
        // 새로운 탭이 선택 되었을 때 onTabSelected에서 코드를 작성하면 된다.
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition(); // 몇 번째 포지션이 눌러졌는지 알 수 있게
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d(TAG, "Reselected"); // 다시 선택(클릭)되었을 때
            }
        });
    }
}
