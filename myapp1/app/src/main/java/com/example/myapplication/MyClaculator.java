package com.example.myapplication;

public class MyClaculator implements ICalc {

    private int number1;
    private int number2;
    private int result;

    private String resultText;

    @Override
    public String add(String a, String b) {
        number1 = Integer.parseInt(a);
        number2 = Integer.parseInt(b);
        result = number1 + number2;
        resultText = String.valueOf(result);
        return resultText;
    }

    @Override
    public String subtract(String a, String b) {
        number1 = Integer.parseInt(a);
        number2 = Integer.parseInt(b);
        result = number1 - number2;
        resultText = String.valueOf(result);
        return resultText;
    }

    @Override
    public String multiply(String a, String b) {
        number1 = Integer.parseInt(a);
        number2 = Integer.parseInt(b);
        result = number1 * number2;
        resultText = String.valueOf(result);
        return resultText;
    }

    @Override
    public String divide(String a, String b) {
        number1 = Integer.parseInt(a);
        number2 = Integer.parseInt(b);
        result = number1 / number2;
        resultText = String.valueOf(result);
        return resultText;
    }
}
