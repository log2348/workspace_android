package com.example.movie_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;

import android.os.Bundle;

import com.example.movie_1.databinding.ActivityMainBinding;
import com.example.movie_1.utils.FragmentType;

public class MainActivity extends AppCompatActivity {
    // 뷰 바인딩 생성 방법
    // 1. 안드로이드가 만들어준 객체 선언
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 2. 객체 초기화
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // 3. 연결 ( findViewById() )
        setContentView(binding.getRoot());
        //binding.temp1.setText("뷰 바인딩 사용했어요 ~");
        replaceFragment(FragmentType.MOVIE);
        addBottomNavigationListener();
    }

    private void replaceFragment(FragmentType type) {
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (type == FragmentType.MOVIE) {
            fragment = MovieFragment.newInstance(); // MOVIE TAG
        } else {
            fragment = InfoFragment.newInstance(); // INFO TAG
        }
        transaction.replace(binding.mainContainer.getId(), fragment, type.toString());
        transaction.commit();
    }

    private void addBottomNavigationListener() {
        binding.bottomNavigation.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.movie:
                    replaceFragment(FragmentType.MOVIE);
                    break;
                case R.id.info:
                    replaceFragment(FragmentType.INFO);
                    break;
            }
            return true;
        });
    }
}