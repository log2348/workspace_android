package com.example.mysecretdiary2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String KEY_PWD = "password";

    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;
    private NumberPicker numberPicker3;

    private Button openDiaryBtn;
    private Button changePasswordBtn;

    private boolean changePasswordMode = false;

    private SharedPreferences passwordPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        addEventListener();
    }

    private void initData() {
        numberPicker1 = findViewById(R.id.numberPicker1);
        numberPicker2 = findViewById(R.id.numberPicker2);
        numberPicker3 = findViewById(R.id.numberPicker3);
        numberPicker1.setMinValue(0);
        numberPicker1.setMaxValue(9);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(9);
        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(9);

        openDiaryBtn = findViewById(R.id.openDiaryBtn);
        changePasswordBtn = findViewById(R.id.changePasswordBtn);

        passwordPreference = getSharedPreferences(KEY_PWD, MODE_PRIVATE);
    }

    private void addEventListener() {

        openDiaryBtn.setOnClickListener(view -> {
            if(changePasswordMode) {
                // 비밀번호 변경 모드일 때 열리면 안됨
                Toast.makeText(this, "비밀번호 변경 중입니다.", Toast.LENGTH_SHORT).show();
                return; // 실행의 제어권 반납
            }

            String passwordFromUser = getPasswordFromUser();

            if(passwordPreference.getString(KEY_PWD, "000").equals(passwordFromUser)) {
                // 비밀번호 일치하면 다음 엑티비티로 전환 (다이어리 열림)
                Intent intent = new Intent(this, DiaryActivity.class);
                startActivity(intent);
            } else {
                showErrorAlertDialog();
            }
        });

        changePasswordBtn.setOnClickListener(view -> {

            String passwordFromUser = getPasswordFromUser();

            if (changePasswordMode) {
                // 비밀번호 변경 -> 저장
                SharedPreferences.Editor editor = passwordPreference.edit();
                editor.putString(KEY_PWD, getPasswordFromUser());
                editor.apply(); // 비동기 처리
                changePasswordBtn.setBackgroundColor(Color.BLACK);
                changePasswordMode = false;
            } else {
                if(passwordPreference.getString(KEY_PWD, "000").equals(passwordFromUser)) {
                    changePasswordMode = true;
                    Toast.makeText(this, "변경할 패스워드를 입력하세요", Toast.LENGTH_SHORT).show();
                    changePasswordBtn.setBackgroundColor(Color.WHITE);
                } else {
                    showErrorAlertDialog();
                }
            }
        });
    }

    private String getPasswordFromUser() {
        String passwordFromUser = "" + numberPicker1.getValue() +
                numberPicker2.getValue() +
                numberPicker3.getValue();
        return passwordFromUser;
    }

    private void showErrorAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("실패")
                .setMessage("패스워드가 일치하지 않습니다.")
                .setPositiveButton("닫기", (dialog, which) -> {

                });
    }
}