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
            // ?????? list ( 1 ~ 5 )
            List<Integer> list = getRandomNumber();

            // set ?????? ???????????? ????????? ?????? ( 1 ~ 5 )
            list.addAll(pickerNumberSet);
            Collections.sort(list);

            didRun = true;

            // xml ??????
            for (int i = 0; i < list.size(); i++) {
                numberTextViewList.get(i).setText(String.valueOf(list.get(i)));
                numberTextViewList.get(i).setVisibility(View.VISIBLE);
                // ???????????? ( 1  ~ 10 ) ( 11 ~ 20 ) ?????? ?????? ?????????
                numberTextViewList.get(i).setBackground(setTextViewBackground(list.get(i)));
            }
        });

        addBtn.setOnClickListener(view -> {
            if (didRun) {
                Toast.makeText(this, "????????? ?????? ??????", Toast.LENGTH_SHORT).show();
            }

            // 1. NumberPicker??? ?????? ?????? ????????????.
            int selectedNumber = numberPicker.getValue();
            Log.d(TAG, selectedNumber + "");

            // ????????? 6????????? ?????? ??????
            if (pickerNumberSet.size() > 5) {
                Toast.makeText(this, "????????? 6????????? ?????? ???????????????.", Toast.LENGTH_SHORT).show();
                return;
            }

            // ????????? ?????? ????????? ?????? ??????
            if (pickerNumberSet.contains(selectedNumber)) {
                Toast.makeText(this, "?????? ????????? ???????????????.", Toast.LENGTH_SHORT).show();
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
        // 1 ~ 45 ?????? ????????? ??????
        for (int i = 1; i < 46; i++) {
            // ?????? ????????? ??????
            if (pickerNumberSet.contains(i)) {
                // ?????? ?????? ????????????
                continue;
            }
            list.add(i); // 1 ~ 45 ?????? ?????????
        }
        // shuffle - ?????? ??????, ????????? ?????? list ????????? ????????? ??? ??????
        Collections.shuffle(list);
        return list.subList(0, 6 - pickerNumberSet.size()); // 0 ~ 6?????? ?????????
    }

    // ?????? ????????? ????????? ?????? ????????? ??????
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