package com.example.mytablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.mytablayout.adapter.MyPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private ViewPager viewPager;
    public TabLayout tabLayout;
    public static int tabCount;
    private MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addListener();
    }

    private void initData() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), tabCount);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_format_list_bulleted_24).setText("ALL"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_access_time_24).setText("RECENT"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_favorite_24).setText("FAVORITE"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_account_circle_24).setText("ACCOUNT"));
        tabCount = tabLayout.getTabCount();

        viewPager.setAdapter(myPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void addListener() {

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
            }
        });
    }
}