package com.example.mareu.ui;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mareu.Model.RoomDetails;
import com.example.mareu.R;
import com.example.mareu.databinding.ActivityAddMeetingBinding;
import com.example.mareu.service.CustomSpinner;

import java.util.Calendar;
import java.util.Locale;

import top.defaults.colorpicker.ColorPickerPopup;

public class AddMeetingActivity extends AppCompatActivity {

    private ActivityAddMeetingBinding bindingA;
    private int hour, minute;
    private CustomSpinner room_spinner;
    private RoomAdapter roomAdapter;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingA = ActivityAddMeetingBinding.inflate(getLayoutInflater());
        View view = bindingA.getRoot();
        setContentView(view);
        initDatePicker();
        roomAdapter = new RoomAdapter(AddMeetingActivity.this, RoomDetails.getRoomList());
        room_spinner.setAdapter(roomAdapter);


        bindingA.nameInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        bindingA.roomSppiner.setSpinnerEventsListener(new CustomSpinner.OnSpinnerEventsListener() {
            @Override
            public void onPopupWindowOpened(Spinner spinner) {
                room_spinner.setBackground(getResources().getDrawable(R.drawable.backround_room_spinner_up));


            }

            @Override
            public void onPopupWindowClosed(Spinner spinner) {
                room_spinner.setBackground(getResources().getDrawable(R.drawable.backround_room_spinner));

            }
        });

        bindingA.datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        bindingA.colorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ColorPickerPopup.Builder(AddMeetingActivity.this)
                        .initialColor(Color.BLUE)
                        .enableBrightness(true)
                        .enableAlpha(true)
                        .okTitle("Choisir")
                        .cancelTitle("Fermer")
                        .showIndicator(true)
                        .showValue(true)
                        .build()
                        .show(view, new ColorPickerPopup.ColorPickerObserver() {
                            @Override
                            public void onColorPicked(int color) {

                                bindingA.colorPicker.setBackgroundColor(color);

                            }

                            @Override
                            public void onColor(int color, boolean fromUser) {

                                bindingA.colorPicker.setBackgroundColor(color);

                            }
                        });

            }
        });

        bindingA.create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        bindingA.timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {


            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month) {
        if (month == 1)
            return "JAN";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "APR";
        if (month == 5)
            return "MAY";
        if (month == 6)
            return "JUN";
        if (month == 7)
            return "JUL";
        if (month == 8)
            return "AUG";
        if (month == 9)
            return "SEP";
        if (month == 10)
            return "OCT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DEC";

        return "JAN";
    }


    public void popTimePicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                hour = selectedHour;
                minute = selectedMinute;
                bindingA.timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));


            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour, minute, true);
        timePickerDialog.setTitle("Déffinissez l'heure");
        timePickerDialog.show();

    }

    public void openDatePicker(View view) {
    }
}