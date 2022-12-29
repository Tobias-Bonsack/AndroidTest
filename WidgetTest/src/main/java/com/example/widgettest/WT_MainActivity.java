package com.example.widgettest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.chip.ChipGroup;

public class WT_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wt_main);

        ((RadioGroup) findViewById(R.id.radioGroup)).setOnCheckedChangeListener((radioGroup, i) -> {
            Toast.makeText(getApplicationContext(), "" + i, Toast.LENGTH_SHORT).show();
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] array = {"A", "B", "C"};
        ArrayAdapter ad = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, array);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(ad);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = String.valueOf(spinner.getItemAtPosition(i));
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "Nothing", Toast.LENGTH_SHORT).show();
            }
        });

        //Time Picker
        Button timeBtn = findViewById(R.id.timePickerBtn);
        timeBtn.setOnClickListener(view -> {
            var timePickerFragment = new TimePickerFragment();
            timePickerFragment.show(getSupportFragmentManager(), "Pick Time");
        });
    }
}