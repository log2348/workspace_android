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
            appendNumber(one);
        });

        two.setOnClickListener(view -> {
            appendNumber(two);
        });

        three.setOnClickListener(view -> {
            appendNumber(three);
        });

        four.setOnClickListener(view -> {
            appendNumber(four);
        });

        five.setOnClickListener(view -> {
            appendNumber(five);
        });

        six.setOnClickListener(view -> {
            appendNumber(six);
        });

        seven.setOnClickListener(view -> {
            appendNumber(seven);
        });

        eight.setOnClickListener(view -> {
            appendNumber(eight);
        });

        nine.setOnClickListener(view -> {
            appendNumber(nine);
        });

        zero.setOnClickListener(view -> {
            appendNumber(zero);
        });

        ca.setOnClickListener(view -> {
            oldValue = "";
            newValue = "";
            resultBox.setText("0");
            Log.d(TAG, "ca 클릭 !!!!");
        });

        plus.setOnClickListener(view -> {
            if (calculateSign != null) {
                /*
                    만약 = 연산이 안 일어난 채로 5 * 5 까지의 값이 담겨있으면
                    그까지의 계산 결과를 내서 oldValue에 담고
                    그 값에서 다시 더하기 연산을 해야 한다.
                 */
                checkCalcSign(oldValue, newValue);
            }
            calculateSign = "+";
            checkCalcSign(oldValue, newValue);
        });

        minus.setOnClickListener(view -> {
            if (calculateSign != null) {
                checkCalcSign(oldValue, newValue);
            }
            calculateSign = "-";
            checkCalcSign(oldValue, newValue);
        });

        multiply.setOnClickListener(view -> {
            if (calculateSign != null) {
                checkCalcSign(oldValue, newValue);
            }
            calculateSign = "*";
            checkCalcSign(oldValue, newValue);
        });

        divide.setOnClickListener(view -> {
            if (calculateSign != null) {
                checkCalcSign(oldValue, newValue);
            }
            calculateSign = "/";
            checkCalcSign(oldValue, newValue);
        });

        equal.setOnClickListener(view -> {
            checkCalcSign(oldValue, newValue);
            calculateSign = "";
            /*
                = 클릭 후 다른 기호를 누르면 최종 값에서 이어서 연산이 되고
                부호 클릭 안하고 숫자를 클릭하면 이전 결과값은 사라지고
                그때부터 클릭하는 숫자부터 처음 계산이 되어야 한다.
             */
        });

    }

    private void appendNumber(TextView number) {
        if (newValue.equals("0")) {
            newValue = number.getText().toString();
        } else {
            newValue = newValue + number.getText().toString();
        }
        resultBox.setText(newValue);
        Log.d(TAG, number.getText() + " 클릭!!!!");
    }


    private void checkCalcSign(String oldNum, String newNum) {

        Log.d(TAG, "연산자 : " + calculateSign);
        Log.d(TAG, "oldValue : " + oldValue);
        Log.d(TAG, "newValue : " + newValue);

        if (!newValue.equals("")) {
            if (!oldValue.equals("")) {
                // old new 둘 다 값이 담겨 있으면
                int number1 = Integer.parseInt(oldNum);
                int number2 = Integer.parseInt(newNum);
                int result = 0;

                switch (calculateSign) {
                    case "+":
                        result = number1 + number2;
                        break;
                    case "-":
                        result = number1 - number2;
                        break;
                    case "*":
                        result = number1 * number2;
                        break;
                    case "/":
                        result = number1 / number2;
                        break;
                }
                // 연산 결과는 old 값에 담아준다
                resultValue = String.valueOf(result);
                oldValue = resultValue;
                resultBox.setText(oldValue);
            } else {
                // old가 비어있으면 new 값을 담아줌
                oldValue = newValue;
            }
        }
        newValue = "";

    }

}
