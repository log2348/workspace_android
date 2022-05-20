package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    private MyCalculator myCalculator;

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

    private String calculateSign = null;

    private String newValue = "";
    private String oldValue = "";
    private String resultValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_calculator);
        initData();
        addEventListener();
    }

    private void initData() {
        myCalculator = new MyCalculator();

        one = findViewById(R.id.one);
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

        System.out.println("initData 메서드 호출");
    }

    private void addEventListener() {

        one.setOnClickListener(view -> {
            if (!newValue.equals("0")) {
                if (newValue.length() == 0) {
                    newValue = "1";
                } else {
                    newValue = newValue + "1";
                }
            }
            resultBox.setText(newValue);
            Log.d("MY TAG", "one 클릭!!!!");
        });

        two.setOnClickListener(view -> {
            if (!newValue.equals("0")) {
                if (newValue.length() == 0) {
                    newValue = "2";
                } else {
                    newValue = newValue + "2";
                }
            }
            resultBox.setText(newValue);
            Log.d("MY TAG", "two 클릭!!!!");
        });

        three.setOnClickListener(view -> {
            if (newValue.length() == 0) {
                newValue = "3";
            } else {
                newValue = newValue + "3";
            }
            resultBox.setText(newValue);
            Log.d(TAG, "three 클릭 !!!!");
        });

        four.setOnClickListener(view -> {
            if (newValue.length() == 0) {
                newValue = "4";
            } else {
                newValue = newValue + "4";
            }
            resultBox.setText(newValue);
            Log.d(TAG, "four 클릭 !!!!");
        });

        five.setOnClickListener(view -> {
            if (newValue.length() == 0) {
                newValue = "5";
            } else {
                newValue = newValue + "5";
            }
            resultBox.setText(newValue);
            Log.d(TAG, "five 클릭 !!!!");
        });

        six.setOnClickListener(view -> {
            if (newValue.length() == 0) {
                newValue = "6";
            } else {
                newValue = newValue + "6";
            }
            resultBox.setText(newValue);
            Log.d(TAG, "six 클릭 !!!!");
        });

        seven.setOnClickListener(view -> {
            if (newValue.length() == 0) {
                newValue = "7";
            } else {
                newValue = newValue + "7";
            }
            resultBox.setText(newValue);
            Log.d(TAG, "seven 클릭 ");
        });

        eight.setOnClickListener(view -> {
            if (newValue.length() == 0) {
                newValue = "8";
            } else {
                newValue = newValue + "8";
            }
            resultBox.setText(newValue);
            Log.d(TAG, "eight 클릭 !!!!");
        });

        nine.setOnClickListener(view -> {
            if (newValue.length() == 0) {
                newValue = "9";
            } else {
                newValue = newValue + "9";
            }
            resultBox.setText(newValue);
            Log.d(TAG, "nine 클릭 !!!!");
        });

        zero.setOnClickListener(view -> {
            if (!(newValue.length() == 0)) {
                newValue = newValue + "0";
            } else {
                newValue = "0";
            }
            resultBox.setText(newValue);
            Log.d(TAG, "oldValue : " + oldValue);
            Log.d(TAG, "newValue : " + newValue);
            Log.d(TAG, "zero 클릭 !!!!");
        });

        ca.setOnClickListener(view -> {
            oldValue = "";
            newValue = "";
            resultBox.setText("0");
            Log.d(TAG, "ca 클릭 !!!!");
        });

        plus.setOnClickListener(view -> {
            if (!newValue.equals("")) {
                resultValue = myCalculator.add(oldValue, newValue);
                oldValue = resultValue;
            } else {
                oldValue = newValue;
            }
            newValue = "";
            calculateSign = "+";
            resultBox.setText(resultValue);

            Log.d(TAG, "oldValue : " + oldValue);
            Log.d(TAG, "newValue : " + newValue);
            Log.d(TAG, "resultValue : " + resultValue);
            Log.d(TAG, "plus 클릭 !!!!");
        });

        minus.setOnClickListener(view -> {
            if (!oldValue.equals("")) {
                resultValue = myCalculator.subtract(oldValue, newValue);
                oldValue = resultValue;
                resultBox.setText(resultValue);
            } else {
                oldValue = newValue;
            }
            newValue = "";
            calculateSign = "-";

            Log.d(TAG, "minus 클릭 !!!!");
        });

        multiply.setOnClickListener(view -> {
            if (!oldValue.equals("")) {
                resultValue = myCalculator.multiply(oldValue, newValue);
                oldValue = resultValue;
                resultBox.setText(resultValue);
            } else {
                oldValue = newValue;
            }
            newValue = "";
            calculateSign = "*";

            Log.d(TAG, "multiply 클릭 !!!!");
        });

        divide.setOnClickListener(view -> {
            if (!oldValue.equals("")) {
                resultValue = myCalculator.divide(oldValue, newValue);
                oldValue = resultValue;
            } else {
                oldValue = newValue;
            }
            newValue = "";
            calculateSign = "/";
            resultBox.setText(resultValue);

            Log.d(TAG, "divide 클릭 !!!!");
        });

        equal.setOnClickListener(view -> {
            switch (calculateSign) {
                case "+":
                    resultValue = myCalculator.add(oldValue, newValue);
                    break;
                case "-":
                    resultValue = myCalculator.subtract(oldValue, newValue);
                    break;
                case "*":
                    resultValue = myCalculator.multiply(oldValue, newValue);
                    break;
                case "/":
                    resultValue = myCalculator.divide(oldValue, newValue);
                    break;
            }
            Log.d(TAG, "oldValue : " + oldValue);
            Log.d(TAG, "newValue : " + newValue);
            Log.d(TAG, "resultValue : " + resultValue);

            resultBox.setText(resultValue);
            oldValue = resultValue;
            newValue = "0";
            calculateSign = null;
        });
    }

}
