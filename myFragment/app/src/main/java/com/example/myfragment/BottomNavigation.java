package com.example.myfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class BottomNavigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        switch (item.getItemId()) {
            case R.id.homeIcon:
                fragment = new FragmentHome();
                transaction.replace(R.id.container, fragment);
                transaction.commit();
                Log.d("TAG", "홈 화면 가기");
                break;
            case R.id.chatIcon:
                fragment = new FragmentChat();
                transaction.replace(R.id.container, fragment);
                transaction.commit();
                Log.d("TAG", "채팅 하기");
                break;
            case R.id.boardIcon:
                fragment = new FragmentBoard();
                transaction.replace(R.id.container, fragment);
                transaction.commit();
                Log.d("TAG", "채팅 하기");
                break;
        }

        return true;
    }
}