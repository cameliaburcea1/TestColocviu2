package com.example.practicaltest01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button buttonLeft;
    Button buttonRight;
    Button button3;
    EditText leftEditText;
    EditText rightEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLeft = findViewById(R.id.pressleftbutton);
        buttonRight = findViewById(R.id.pressrightbutton);

        leftEditText = findViewById(R.id.leftedittext);
        rightEditText = findViewById(R.id.rightedittext);
        leftEditText.setText("0");
        rightEditText.setText("0");


        buttonLeft.setOnClickListener(view -> {
            int leftNoClicks = Integer.parseInt(leftEditText.getText().toString());
            leftNoClicks++;
            leftEditText.setText(String.valueOf(leftNoClicks));
        });

        buttonRight.setOnClickListener(view -> {
            int rightNoClicks = Integer.parseInt(rightEditText.getText().toString());
            rightNoClicks++;
            rightEditText.setText(String.valueOf(rightNoClicks));
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("LEFT_NO_CLICKS", leftEditText.getText().toString());
        outState.putString("RIGHT_NO_CLICKS", rightEditText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        leftEditText.setText(savedInstanceState.getString("LEFT_NO_CLICKS"));
        rightEditText.setText(savedInstanceState.getString("RIGHT_NO_CLICKS"));

        if (savedInstanceState.containsKey("LEFT_NO_CLICKS")) {
            leftEditText.setText(savedInstanceState.getString("LEFT_NO_CLICKS"));
        } else {
            leftEditText.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("RIGHT_NO_CLICKS")) {
            rightEditText.setText(savedInstanceState.getString("RIGHT_NO_CLICKS"));
        } else {
            rightEditText.setText(String.valueOf(0));
        }
    }
}