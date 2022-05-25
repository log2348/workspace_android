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
import android.widget.Toast;

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

        switch (item.getItemId()) {
            case R.id.homeIcon:
                Toast.makeText(this, "홈 아이콘 선택", Toast.LENGTH_SHORT).show();
                break;
            case R.id.chatIcon:
                Toast.makeText(this, "채팅 아이콘 선택", Toast.LENGTH_SHORT).show();
                break;
            case R.id.boardIcon:
                Toast.makeText(this, "게시판 아이콘 선택", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}