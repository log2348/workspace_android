package com.example.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.viewpager2.adapter.ViewPagerAdapter;

import java.util.ArrayList;

public class MyViewPager2 extends AppCompatActivity {

    private ViewPager2 imageSlider;
    private ArrayList<String> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_pager2);

        images.add("https://cdn.pixabay.com/photo/2019/11/23/03/08/valley-4646114_960_720.jpg");
        images.add("https://cdn.pixabay.com/photo/2019/04/08/16/49/blooming-4112348_960_720.jpg");
        images.add("https://cdn.pixabay.com/photo/2021/07/19/22/07/mountains-6479150_960_720.jpg");
        images.add("https://cdn.pixabay.com/photo/2019/06/24/16/43/mountain-4296464_960_720.jpg");
        images.add("https://cdn.pixabay.com/photo/2016/10/25/11/37/snow-1768544__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2019/07/21/18/30/mountain-4353332_960_720.jpg");

        imageSlider = findViewById(R.id.myViewPager2);
        imageSlider.setOffscreenPageLimit(2);
        imageSlider.setAdapter(new ViewPagerAdapter(this, images));

    }
}