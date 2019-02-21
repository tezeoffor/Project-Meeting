package com.example.thankgodezeoffor.projectmeetingapp;

/**
 * CreateNewMeetingActivity takes user input
 * and adds the data to the meeting list
 */

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class CreateNewMeetingActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "CreateNewMeetingActivity";
    private TextView displayDate;
    private TextView displayTime;
    private  DatePickerDialog.OnDateSetListener dateSetListener;
    private  TimePickerDialog.OnTimeSetListener timeSetListener;

    Button selectLocation;
    Button addAttendees;
    Button closeCreateMeetingButton;
    EditText meetingTitle;
    Button createMeeting;

    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_meeting);

        //meeting title declaration
         meetingTitle = findViewById(R.id.meeting_title);
         meetingTitle.setOnClickListener(this);

        //date picker declaration
        displayDate = findViewById(R.id.date_field);
        displayDate.setOnClickListener(this);

        //time picker declaration
        displayTime = findViewById(R.id.time_field);
        displayTime.setOnClickListener(this);

        //Set location button definition
        selectLocation = findViewById(R.id.set_location_btn);
        selectLocation.setOnClickListener(this);

        //Add attendees button definition
        addAttendees = findViewById(R.id.add_attendees_btn);
        addAttendees.setOnClickListener(this);

        createMeeting = findViewById(R.id.create_button);
        createMeeting.setOnClickListener(this);

        //close button declaration
        closeCreateMeetingButton = findViewById(R.id.close_creating_meeting_btn);
        closeCreateMeetingButton.setOnClickListener(this);

        /**
         * checks if display id have been clicked
         * Adds a DatePicker dialog
         */
        displayDate.setOnClickListener(this);
        /**
         * checks if display id have been clicked
         * Adds a DatePicker dialog
         */
        displayTime.setOnClickListener(this);

        //Data base helper declaration
        mDatabaseHelper = new DatabaseHelper(this);

    }
    public  void AddData(String newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData){
            toastMessage("good");
        }else {
            toastMessage("wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    /**
     * This method checks if any of the listed button has been clicked
     * if any of the button is clicked
     * perform the operation
     * @param v
     */

    @Override
    public void onClick(View v) {
        if (v.getId() == displayDate.getId()){
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            /**
             * sets DatePickerDialog
             * Display date
             */
            dateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    month = month + 1;
                    Log.d(TAG, "onDateSet: mm/dd/yyy :" + month + "-" + day + "-" + year);

                    String date = month + "-" + day + "-" + year;
                    displayDate.setText(date);
                }
            };


            DatePickerDialog dialog = new DatePickerDialog(CreateNewMeetingActivity.this,
                    android.R.style.Theme_Holo_Dialog_MinWidth,
                    dateSetListener,year,day,month);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        }else if (v.getId() == displayTime.getId()){
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minutes = calendar.get(Calendar.MINUTE);

            /**
             * sets DatePickerDialog
             * Display date
             */
            timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hour, int minute) {
                    Log.d(TAG, "Time :" + hour + ":" + minute);

                    String time = hour + ":" + minute;
                    displayTime.setText(time);

                }
            };


            TimePickerDialog timePickerDialog = new TimePickerDialog(this,timeSetListener,hour,minutes,false);

            timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            timePickerDialog.show();
        }else if (v.equals(findViewById(R.id.set_location_btn))){
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        } else if (v.equals(findViewById(R.id.add_attendees_btn))){
            Intent intent = new Intent(this, AddAttendeesActivity.class);
            startActivity(intent);
        }
          else if(v.equals(findViewById(R.id.close_creating_meeting_btn))){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else if(v.equals(findViewById(R.id.create_button))){
            Intent intent = new Intent(this, MainActivity.class);
        }



    }
}
