package com.example.callbacktest;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.callbacktest.databinding.ActivityMainBinding;
import com.example.callbacktest.utils.FragmentType;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(FragmentType.LIST);
        addBottomNavigationListener();
    }

    private void addBottomNavigationListener() {
        binding.bottomNavigation.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.movieListicon:
                    replaceFragment(FragmentType.LIST);
                    break;
                case R.id.webIcon:
                    replaceFragment(FragmentType.WEB);
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(FragmentType type) {
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (type == FragmentType.LIST) {
            fragment = CardViewFragment.getInstance();
            Log.d("TAG", "List Fragment");
        } else {
            fragment = WebViewFragment.getInstance();
        }
        transaction.replace(binding.mainContainer.getId(), fragment, type.toString());
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        // Back 버튼 클릭시 호출

//            if (webView.canGoBack()) {
//                webView.goBack();
//                Log.d("TAG", "canGoBack()");
//                Toast.makeText(this, "한 번 더 누르면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show();
//            } else {
//                super.onBackPressed();
//                Log.d("TAG", "super.onBackPressed()");
    }
}