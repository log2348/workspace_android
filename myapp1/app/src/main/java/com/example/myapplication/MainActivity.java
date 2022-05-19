package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    private MyClaculator myClaculator;

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

    private boolean plusCheck;
    private boolean minusCheck;
    private boolean multiplyCheck;
    private boolean divideCheck;

    private String newValue = "0";
    private String oldValue = "0";
    private String resultValue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_calculator);
        initData();
        addEventListener();
    }

    // 호출시 스택 메모리에 올라갔다 사라진다
    private void initData() {
        myClaculator = new MyClaculator();

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
        equal = findViewById(R.id.equal);
        resultBox = findViewById(R.id.result);

        System.out.println("initData 메서드 호출"); // 안드로이드에서는 sysout 거의 안 씀
    }

    private void addEventListener() {
        // 익명 구현 객체
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newValue.equals("0")) {
                    newValue = "1";
                } else {
                    oldValue = String.valueOf(resultBox.getText());
                    newValue = oldValue + "1";
                }
                resultBox.setText(newValue);
                Log.d("MY TAG", "one 클릭!!!!");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newValue.equals("0")) {
                    newValue = "2";
                } else {
                    oldValue = String.valueOf(resultBox.getText());
                    newValue = oldValue + "2";
                }
                resultBox.setText(newValue);
                Log.d("MY TAG", "two 클릭!!!!");
            }
        });

        // 람다 표현식
        three.setOnClickListener(view -> {
            if (newValue.equals("0")) {
                newValue = "3";
            } else {
                oldValue = String.valueOf(resultBox.getText());
                newValue = oldValue + "3";
            }
            resultBox.setText(newValue);
            Log.d(TAG, "three 클릭 !!!!");
        });

        four.setOnClickListener(view -> {
            if (newValue.equals("0")) {
                newValue = "4";
            } else {
                oldValue = String.valueOf(resultBox.getText());
                newValue = oldValue + "4";
            }
            resultBox.setText(newValue);
            Log.d(TAG, "four 클릭 !!!!");
        });

        five.setOnClickListener(view -> {
            if (newValue.equals("0")) {
                newValue = "5";
            } else {
                oldValue = String.valueOf(resultBox.getText());
                newValue = oldValue + "5";
            }
            resultBox.setText(newValue);
            Log.d(TAG, "five 클릭 !!!!");
        });

        six.setOnClickListener(view -> {
            if (newValue.equals("0")) {
                newValue = "6";
            } else {
                oldValue = String.valueOf(resultBox.getText());
                newValue = oldValue + "6";
            }
            resultBox.setText(newValue);
            Log.d(TAG, "six 클릭 !!!!");
        });

        seven.setOnClickListener(view -> {
            if (newValue.equals("0")) {
                newValue = "7";
            } else {
                oldValue = String.valueOf(resultBox.getText());
                newValue = oldValue + "7";
            }
            resultBox.setText(newValue);
            Log.d(TAG, "seven 클릭 !!!!");
        });

        eight.setOnClickListener(view -> {
            if (newValue.equals("0")) {
                newValue = "8";
            } else {
                oldValue = String.valueOf(resultBox.getText());
                newValue = oldValue + "8";
            }
            resultBox.setText(newValue);
            Log.d(TAG, "eight 클릭 !!!!");
        });

        nine.setOnClickListener(view -> {
            if (newValue.equals("0")) {
                newValue = "9";
            } else {
                oldValue = String.valueOf(resultBox.getText());
                newValue = oldValue + "9";
            }
            resultBox.setText(newValue);
            Log.d(TAG, "nine 클릭 !!!!");
        });

        zero.setOnClickListener(view -> {
            if (!(newValue.equals("0"))) {
                oldValue = newValue;
                newValue = oldValue + "0";
            }
            resultBox.setText(newValue);
            Log.d(TAG, "oldValue : " + oldValue);
            Log.d(TAG, "newValue : " + newValue);
            Log.d(TAG, "zero 클릭 !!!!");
        });

        ca.setOnClickListener(view -> {
            newValue = "0";
            oldValue = "0";
            resultBox.setText(newValue);
            Log.d(TAG, "ca 클릭 !!!!");
        });

        plus.setOnClickListener(view -> {
            plusCheck = true;
            oldValue = String.valueOf(resultBox.getText());
            newValue = "0";
            Log.d(TAG, "plus 클릭 !!!!");
        });

        minus.setOnClickListener(view -> {
            minusCheck = true;
            oldValue = String.valueOf(resultBox.getText());
            newValue = "0";
            Log.d(TAG, "minus 클릭 !!!!");
        });

        multiply.setOnClickListener(view -> {
            multiplyCheck = true;
            oldValue = String.valueOf(resultBox.getText());
            newValue = "0";
            Log.d(TAG, "multiply 클릭 !!!!");
        });

        divide.setOnClickListener(view -> {
            divideCheck = true;
            oldValue = String.valueOf(resultBox.getText());
            newValue = "0";
            Log.d(TAG, "divide 클릭 !!!!");
        });

        equal.setOnClickListener(view -> {

            if (plusCheck) {
                resultValue = myClaculator.add(oldValue, newValue);
                Log.d(TAG, "oldValue : " + oldValue);
                Log.d(TAG, "newValue : " + newValue);
                Log.d(TAG, "resultValue : " + resultValue);
                plusCheck = false;
            } else if (minusCheck) {
                resultValue = myClaculator.subtract(oldValue, newValue);
                Log.d(TAG, "oldValue : " + oldValue);
                Log.d(TAG, "newValue : " + newValue);
                Log.d(TAG, "resultValue : " + resultValue);
                minusCheck = false;
            } else if (multiplyCheck) {
                resultValue = myClaculator.multiply(oldValue, newValue);
                Log.d(TAG, "oldValue : " + oldValue);
                Log.d(TAG, "newValue : " + newValue);
                Log.d(TAG, "resultValue : " + resultValue);
                multiplyCheck = false;
            } else if (divideCheck) {
                resultValue = myClaculator.divide(oldValue, newValue);
                Log.d(TAG, "oldValue : " + oldValue);
                Log.d(TAG, "newValue : " + newValue);
                Log.d(TAG, "resultValue : " + resultValue);
                divideCheck = false;
            }
            newValue = "0";
            resultBox.setText(resultValue);

        });
    }
}
