package com.example.lotto_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName(); // MainActivity

    private Button addBtn;
    private Button initBtn;
    private Button runBtn;
    private NumberPicker numberPicker;

    private ArrayList<TextView> numberTextViewList = new ArrayList<TextView>();
    private Set<Integer> pickerNumberSet = new HashSet<>();
    private boolean didRun = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();
        getRandomNumber();
        // Log.d(TAG, "getRandomNumber() : " + getRandomNumber());
    }

    private void initData() {
        addBtn = findViewById(R.id.addButton);
        initBtn = findViewById(R.id.initButton);
        runBtn = findViewById(R.id.runButton);

        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(45);

        numberTextViewList.add(findViewById(R.id.textView1));
        numberTextViewList.add(findViewById(R.id.textView2));
        numberTextViewList.add(findViewById(R.id.textView3));
        numberTextViewList.add(findViewById(R.id.textView4));
        numberTextViewList.add(findViewById(R.id.textView5));
        numberTextViewList.add(findViewById(R.id.textView6));
    }

    private void addEventListener() {
        runBtn.setOnClickListener(view -> {
            // 랜덤 list ( 1 ~ 5 )
            List<Integer> list = getRandomNumber();

            // set 계열 사용자가 선택한 번호 ( 1 ~ 5 )
            list.addAll(pickerNumberSet);
            Collections.sort(list);

            didRun = true;

            // xml 출력
            for (int i = 0; i < list.size(); i++) {
                numberTextViewList.get(i).setText(String.valueOf(list.get(i)));
                numberTextViewList.get(i).setVisibility(View.VISIBLE);
                // 도전과제 ( 1  ~ 10 ) ( 11 ~ 20 ) 배경 색상 다르게
                numberTextViewList.get(i).setBackground(setTextViewBackground(list.get(i)));
            }
        });

        addBtn.setOnClickListener(view -> {
            if (didRun) {
                Toast.makeText(this, "초기화 후에 시도", Toast.LENGTH_SHORT).show();
            }

            // 1. NumberPicker의 현재 값을 불러온다.
            int selectedNumber = numberPicker.getValue();
            Log.d(TAG, selectedNumber + "");

            // 번호는 5개까지 선택 가능
            if (pickerNumberSet.size() >= 5) {
                Toast.makeText(this, "번호는 5개까지 선택 가능합니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            // 똑같은 번호 선택시 예외 처리
            if (pickerNumberSet.contains(selectedNumber)) {
                Toast.makeText(this, "이미 선택한 번호입니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            TextView textView = numberTextViewList.get(pickerNumberSet.size());
            textView.setVisibility(View.VISIBLE);
            textView.setText(String.valueOf(selectedNumber));
            textView.setBackground(setTextViewBackground(selectedNumber));

            pickerNumberSet.add(selectedNumber);
        });

        initBtn.setOnClickListener(view -> {
            didRun = false;
            pickerNumberSet.clear();

            for (TextView tv : numberTextViewList) {
                tv.setVisibility(View.GONE);
            }
        });
    }

    private List<Integer> getRandomNumber() {
        ArrayList<Integer> list = new ArrayList<>();
        // 1 ~ 45 미리 만들어 두자
        for (int i = 1; i < 46; i++) {
            // 자료 구조에 담기
            if (pickerNumberSet.contains(i)) {
                // 번호 중복 안되도록
                continue;
            }
            list.add(i); // 1 ~ 45 값이 담긴다
        }
        // shuffle - 랜덤 배치, 순서가 있는 list 계열만 들어갈 수 있다
        Collections.shuffle(list);
        return list.subList(0, 6 - pickerNumberSet.size()); // 0 ~ 6까지 잘라라
    }

    // 숫자 크기에 따라서 배경 다르게 만듦
    private Drawable setTextViewBackground(int number) {
        Drawable drawable;
        if (number >= 20) {
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background2);
        } else {
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background1);
        }
        return drawable;
    }
}