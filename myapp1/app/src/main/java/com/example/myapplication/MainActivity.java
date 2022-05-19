package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    private TextView one;
    private TextView two;
    private TextView three;
    private TextView four;
    private TextView five;
    private TextView six;
    private TextView seven;
    private TextView nine;
    private TextView eight;
    private TextView zero;
    private TextView ca;
    private TextView plus;

    private TextView result;

    String newValue = "0";
    String oldValue = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.claculator);
        initData();
        addEventListener();
    }

    // 호출시 스택 메모리에 올라갔다 사라진다
    private void initData() {
        one = findViewById(R.id.one); // 주소값을 담는 것
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        ca = findViewById(R.id.ca);
        plus = findViewById(R.id.plus);
        result = findViewById(R.id.result);

        System.out.println("initData 메서드 호출");
    }

    private void addEventListener() {
        // 익명 구현 객체
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newValue = newValue + "1";
                result.setText(newValue);
                Log.d("MY TAG", "one 클릭!!!!");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newValue = newValue + "2";
                result.setText(newValue);
                Log.d("MY TAG", "two 클릭!!!!");
            }
        });

        // 람다 표현식
        three.setOnClickListener(view -> {
            newValue = newValue + "3";
            result.setText(newValue);
          Log.d(TAG, "three 클릭 !!!!");
        });

        four.setOnClickListener(view -> {
            newValue = newValue + "4";
            result.setText(newValue);
            Log.d(TAG, "four 클릭 !!!!");
        });

        five.setOnClickListener(view -> {
            newValue = newValue + "5";
            result.setText(newValue);
            Log.d(TAG, "five 클릭 !!!!");
        });

        six.setOnClickListener(view -> {
            newValue = newValue + "6";
            result.setText(newValue);
            Log.d(TAG, "six 클릭 !!!!");
        });

        seven.setOnClickListener(view -> {
            newValue = newValue + "7";
            result.setText(newValue);
            Log.d(TAG, "seven 클릭 !!!!");
        });

        eight.setOnClickListener(view -> {
            newValue = newValue + "8";
            result.setText(newValue);
            Log.d(TAG, "eight 클릭 !!!!");
        });

        nine.setOnClickListener(view -> {
            newValue = newValue + "9";
            result.setText(newValue);
            Log.d(TAG, "nine 클릭 !!!!");
        });

        zero.setOnClickListener(view -> {
            newValue = newValue + "0";
            result.setText(newValue);
            Log.d(TAG, "zero 클릭 !!!!");
        });

        ca.setOnClickListener(view -> {
            newValue = "0";
            oldValue = "0";
            result.setText("0");
            Log.d(TAG, "ca 클릭 !!!!");
        });

        plus.setOnClickListener(view -> {
            // 1. (newValue = 1)

            int number1 = Integer.parseInt(oldValue);
            int number2 = Integer.parseInt(newValue);
            int sum = number1 + number2;
            Log.d(TAG, "number1 : " + number1);
            Log.d(TAG, "number2 : " + number2);
            Log.d(TAG, "sum : " + sum);

            oldValue = String.valueOf(sum);
            newValue = "0";
            result.setText(oldValue);

            Log.d(TAG, "plus 클릭 !!!!");
        });
    }
}