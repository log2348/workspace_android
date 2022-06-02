package com.example.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.viewpager2.adapter.ViewPagerAdapter;

import java.util.ArrayList;

public class MyViewPager2 extends AppCompatActivity {

    private ViewPager2 imageSlider;
    private ArrayList<String> images = new ArrayList<>();
    private LinearLayout indicatorsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_pager2);

        images.add("https://postfiles.pstatic.net/MjAyMjA0MjNfMjE5/MDAxNjUwNzEyNzA3ODM1.Qaf8aU-WnVUv61z3ukBaT6LCl5m_QJa6Hgs_sXb5hXYg.hXfrWuN7GYYUMLdYrYwwobJjrkTW5MKrsvwtPCbqo5Mg.PNG.sw20woo/image.png?type=w773");
        images.add("https://postfiles.pstatic.net/MjAyMjAyMjBfMjAw/MDAxNjQ1MzU4MjA5NDQz.vC9tYW6r0f4Di8PvObiHy-xT5J3Md3VThCSxpdvw0rog.sp2zZGkNaK1d5ALMCD6lFEildc4ZQcPE1YjpdbgnWkQg.JPEG.leehyne/lyh-024.jpg?type=w966");
        images.add("https://postfiles.pstatic.net/MjAyMjAyMjBfNzgg/MDAxNjQ1MzU4MjA3Njg0.xQ6M9gY0SHEUXIp2dO8_JOW_ZEdkxAx91mc3z_6nQ9cg.fyC7Pyilhx74KjhRMqiHX4EzhdPhZbUVX453ZQDie38g.JPEG.leehyne/lyh-007.jpg?type=w966");
        images.add("https://postfiles.pstatic.net/MjAyMjA0MjNfMTgx/MDAxNjUwNzEyNjI3Nzk2.bcoAIOoha1_wJDtgdx1fBO1bEqh3oqmCJNoft1REHwYg.CL4cnWBeL6fyHU5ZL1FM6JTFdHCv9jL70Uk3t1NDvWAg.PNG.sw20woo/image.png?type=w773");

        indicatorsContainer = findViewById(R.id.indicatorsContainer);
        imageSlider = findViewById(R.id.myViewPager2); // 뷰페이저 객체

        // 현재 보여지는 화면에서 몇 개의 페이지를 유지할지 설정
        imageSlider.setOffscreenPageLimit(2);

        // 뷰페이저와 어댑터 연결
        // 어댑터 생성시 이미지에 대한 정보를 넘겨서 뷰 컴포넌트에 이미지를 올린다
        imageSlider.setAdapter(new ViewPagerAdapter(this, images));

        imageSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            // 페이지 선택될때 호출
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });
        setupIndicators(images.size());
    }

    private void setupIndicators(int count) {
        ImageView[] indicators = new ImageView[count];

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bg_indicator_inactive));

            indicators[i].setLayoutParams(params);
            indicatorsContainer.addView(indicators[i]);
        }
    }

    private void setCurrentIndicator(int position) {
        int childCount = indicatorsContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) indicatorsContainer.getChildAt(i);
            if (i == position) { // 선택되었을 때
                imageView.setImageDrawable(ContextCompat.getDrawable(this,
                        R.drawable.bg_indicator_active));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(this,
                        R.drawable.bg_indicator_inactive));
            }
        }
    }
}