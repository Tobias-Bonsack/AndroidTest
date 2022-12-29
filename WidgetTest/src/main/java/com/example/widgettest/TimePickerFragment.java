package com.example.widgettest;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();

        return new TimePickerDialog(getActivity(), this, c.get(Calendar.HOUR), c.get(Calendar.MINUTE), true);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        Toast.makeText(getContext(), "Time: " + timePicker.getHour() + ":" + timePicker.getMinute(), Toast.LENGTH_SHORT).show();
    }
}
