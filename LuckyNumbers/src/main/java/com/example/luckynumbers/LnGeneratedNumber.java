package com.example.luckynumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class LnGeneratedNumber extends AppCompatActivity {

    private String _name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ln_generated_number);
        _name = getIntent().getStringExtra("username");

        TextView numberText = findViewById(R.id.numberText);
        int randomNumber = new Random().ints(0, 999).findFirst().getAsInt();
        numberText.setText("" + randomNumber);

        ((TextView) findViewById(R.id.textView3)).setText(_name);

        findViewById(R.id.button).setOnClickListener(view -> {
            shareData(_name, randomNumber);
        });
    }

    void shareData(String userName, int number) {

        // implicit intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, userName);
        intent.putExtra(Intent.EXTRA_TEXT, "My lucky number is: " + number);

        startActivity(Intent.createChooser(intent, "Choose a Platform:"));
    }
}