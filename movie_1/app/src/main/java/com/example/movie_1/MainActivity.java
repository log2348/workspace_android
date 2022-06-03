package com.example.movie_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.movie_1.databinding.ActivityMainBinding;
import com.example.movie_1.interfaces.OnChangeToolbarType;
import com.example.movie_1.utils.Define;
import com.example.movie_1.utils.FragmentType;

public class MainActivity extends AppCompatActivity implements OnChangeToolbarType {
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
        // binding.temp1.setText("뷰 바인딩 사용했어요 ~");
        replaceFragment(FragmentType.MOVIE);
        addBottomNavigationListener();
    }

    private void replaceFragment(FragmentType type) {
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (type == FragmentType.MOVIE) {
            fragment = MovieFragment.getInstance(this); // MOVIE TAG
        } else {
            fragment = InfoFragment.getInstance(this); // INFO TAG
        }

        // tag -> 문자열로 이름 지어서 구분 해놓는 녀석
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

    // 뒤로가기 버튼
    @Override
    public void onBackPressed() {
        // info fragment라면 한번은 movie 갔다가 --> 동작
        // movie fragment라면 종료
        // mainContainer --> 올라와있는 녀석이 현재 movieFragment인지 infoFragment인지 구분할 수 있다면 기능 완성할 수 있다.
        String fragmentTag = getSupportFragmentManager()
                .findFragmentByTag(FragmentType.INFO.toString()).getTag();

        if (fragmentTag.equals(FragmentType.INFO.toString())) {
            //replaceFragment(FragmentType.MOVIE);
            View view = binding.bottomNavigation.findViewById(R.id.movie);
            view.callOnClick();
        } else {
            super.onBackPressed();

        }
    }

    @Override
    public void onSetupType(String title) {
        // 프래그먼트에서 호출하면 (onSetupType)
        Log.d("TAG", "title : " + title);
        /*
        if (title.equals(Define.PAGE_TITLE_MOVIE)) {
            binding.topAppbar.setTitle(title);
            binding.topAppbar.setVisibility(View.VISIBLE);
        } else if (title.equals(Define.PAGE_TITLE_INFO)) {
            binding.topAppbar.setVisibility(View.GONE);
        }
         */
        binding.topAppbar.setTitle(title);
        binding.topAppbar.setVisibility(View.VISIBLE);
    }
}