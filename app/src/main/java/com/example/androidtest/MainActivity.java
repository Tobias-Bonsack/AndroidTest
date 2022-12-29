package com.example.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import com.example.luckynumbers.LnMainActivity;
import com.example.widgettest.WT_MainActivity;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.testmenu, menu);
        MenuItem switcher = menu.findItem(R.id.app_bar_switch);

        switcher.setOnMenuItemClickListener(menuItem -> {
            switcher.setChecked(!switcher.isChecked());
            return true;
        });

        menu.findItem(R.id.widgetsMI).setOnMenuItemClickListener(menuItem -> {
            startActivity(new Intent(getApplicationContext(), WT_MainActivity.class));
            return true;
        });

        return true;
    }
}