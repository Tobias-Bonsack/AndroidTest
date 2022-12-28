package com.example.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.luckynumbers.LnMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.intentBtn).setOnClickListener(view ->
                startActivity(new Intent(getApplicationContext(), MainActivity2.class))
        );

        findViewById(R.id.luckyNumberBtn).setOnClickListener(view ->
                startActivity(new Intent(getApplicationContext(), LnMainActivity.class))
        );

    }
}