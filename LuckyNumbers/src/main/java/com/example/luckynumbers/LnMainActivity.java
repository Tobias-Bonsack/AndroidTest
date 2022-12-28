package com.example.luckynumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LnMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ln_main);

        EditText viewById = findViewById(R.id.nameET);
        findViewById(R.id.enterNameBtn).setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LnGeneratedNumber.class);
            intent.putExtra("username", viewById.getText().toString());
            startActivity(intent);
        });
    }
}