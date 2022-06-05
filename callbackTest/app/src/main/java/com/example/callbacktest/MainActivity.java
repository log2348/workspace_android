package com.example.callbacktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnButtonClicked {

    private TextView nameTextField;
    private TextView ageTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextField = findViewById(R.id.nameTextField);
        ageTextField = findViewById(R.id.ageTextField);
    }

    @Override
    public void sendData() {
        String name = nameTextField.getText().toString();
        int age = Integer.parseInt(ageTextField.getText().toString());


    }
}