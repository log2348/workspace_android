package com.example.movie_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import com.example.movie_2.databinding.ActivityMainBinding;
import com.example.movie_2.interfaces.OnTopAppBarTitleChanged;
import com.example.movie_2.interfaces.OnWebViewBackPressed;
import com.example.movie_2.utils.Define;
import com.example.movie_2.utils.FragmentType;

public class MainActivity extends AppCompatActivity implements OnTopAppBarTitleChanged, OnWebViewBackPressed {

    private ActivityMainBinding binding;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(FragmentType.MOVIE);
        addBottomNavigationListener();
    }

    private void replaceFragment(FragmentType type) {
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (type == FragmentType.MOVIE) {
            fragment = MovieFragment.getInstance(this);
        } else {
            fragment = InfoFragment.getInstance(this);
            if (fragment != null) {
                InfoFragment infoFragment = (InfoFragment) fragment;
                // 콜백
                infoFragment.setOnWebViewBackPressed(this);
            }
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

    @Override
    public void setTopAppBar(String title) {
        if (title.equals(Define.PAGE_TITLE_MOVIE)) {
            binding.topAppBar.setTitle("MOVIE");
            binding.topAppBar.setVisibility(View.VISIBLE); // Visible 처리 안 하면 안 보임
        } else if (title.equals(Define.PAGE_TITLE_INFO)) {
            // 상단 바 사라지도록
            binding.topAppBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        // 뒤로가기 버튼 눌렀을 때 호출되는 메서드
        // Acrivity가 내부적으로 구현하는 메서드
        // 뒤로가기 버튼 눌렀을 때 개발자가 화면을 뒤로가는 기능 뿐만 아니라 다른 기능도 구현할 수 있음

        String fragmentTag = getSupportFragmentManager().findFragmentByTag(FragmentType.INFO.toString()).getTag();

        if (fragmentTag.equals(FragmentType.INFO.toString())){
            if (webView.canGoBack()) {
                webView.goBack();
                Log.d("TAG", "onBackPressed()");
            } else {
                View view = binding.bottomNavigation.findViewById(R.id.movie);
                view.callOnClick();
            }
        }
    }

    @Override
    public void onPassWebViewPage(WebView webView) {
        this.webView = webView;
    }
}