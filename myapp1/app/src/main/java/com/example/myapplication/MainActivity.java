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
    private TextView minus;
    private TextView multiply;
    private TextView divide;
    private TextView equal;

    private TextView resultBox;

    String newValue = "0";
    String oldValue = "0";

    int result;

    String calculateSign;

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
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        resultBox = findViewById(R.id.result);

        System.out.println("initData 메서드 호출");
    }

    private void addEventListener() {
        // 익명 구현 객체
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resultBox.getText().equals("0")) {
                    resultBox.setText("1");
                } else {
                    oldValue = resultBox.getText().toString();
                    newValue = oldValue + "1";
                    resultBox.setText(newValue);
                }
                Log.d("MY TAG", "one 클릭!!!!");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resultBox.getText().equals("0")) {
                    resultBox.setText("2");
                } else {
                    oldValue = resultBox.getText().toString();
                    newValue = oldValue + "2";
                    resultBox.setText(newValue);
                }
                Log.d("MY TAG", "two 클릭!!!!");
            }
        });

        // 람다 표현식
        three.setOnClickListener(view -> {
            if(resultBox.getText().equals("0")) {
                resultBox.setText("3");
            } else {
                oldValue = resultBox.getText().toString();
                newValue = oldValue + "3";
                resultBox.setText(newValue);
            }
          Log.d(TAG, "three 클릭 !!!!");
        });

        four.setOnClickListener(view -> {
            if(resultBox.getText().equals("0")) {
                resultBox.setText("4");
            } else {
                oldValue = resultBox.getText().toString();
                newValue = oldValue + "4";
                resultBox.setText(newValue);
            }
            Log.d(TAG, "four 클릭 !!!!");
        });

        five.setOnClickListener(view -> {
            if(resultBox.getText().equals("0")) {
                resultBox.setText("5");
            } else {
                oldValue = resultBox.getText().toString();
                newValue = oldValue + "5";
                resultBox.setText(newValue);
            }
            Log.d(TAG, "five 클릭 !!!!");
        });

        six.setOnClickListener(view -> {
            if(resultBox.getText().equals("0")) {
                resultBox.setText("6");
            } else {
                oldValue = resultBox.getText().toString();
                newValue = oldValue + "6";
                resultBox.setText(newValue);
            }
            Log.d(TAG, "six 클릭 !!!!");
        });

        seven.setOnClickListener(view -> {
            if(resultBox.getText().equals("0")) {
                resultBox.setText("7");
            } else {
                oldValue = resultBox.getText().toString();
                newValue = oldValue + "7";
                resultBox.setText(newValue);
            }
            Log.d(TAG, "seven 클릭 !!!!");
        });

        eight.setOnClickListener(view -> {
            if(resultBox.getText().equals("0")) {
                resultBox.setText("8");
            } else {
                oldValue = resultBox.getText().toString();
                newValue = oldValue + "8";
                resultBox.setText(newValue);
            }
            Log.d(TAG, "eight 클릭 !!!!");
        });

        nine.setOnClickListener(view -> {
            newValue = newValue + "9";
            resultBox.setText(newValue);
            Log.d(TAG, "nine 클릭 !!!!");
        });

        zero.setOnClickListener(view -> {
            newValue = newValue + "0";
            resultBox.setText(newValue);
            Log.d(TAG, "zero 클릭 !!!!");
        });

        ca.setOnClickListener(view -> {
            newValue = "0";
            oldValue = "0";
            resultBox.setText("0");
            Log.d(TAG, "ca 클릭 !!!!");
        });

        plus.setOnClickListener(view -> {

            oldValue = resultBox.getText().toString();

            int number1 = Integer.parseInt(oldValue);
            int number2 = Integer.parseInt(newValue);
            int sum = number1 + number2;
            Log.d(TAG, "number1 : " + number1);
            Log.d(TAG, "number2 : " + number2);
            Log.d(TAG, "sum : " + sum);

            oldValue = String.valueOf(sum);
            newValue = "0";
            resultBox.setText(oldValue);

            calculateSign = "+";

            Log.d(TAG, "plus 클릭 !!!!");
        });

        minus.setOnClickListener(view -> {

        });

        multiply.setOnClickListener(view -> {

        });

        divide.setOnClickListener(view -> {

        });

        equal.setOnClickListener(view -> {

            switch (calculateSign) {
                case "+" :

                    break;
                case "-" :

                    break;
                case "x" :

                    break;
                case "/" :

                    break;
                case "=" :

                    break;
            }


        });
    }
}