package com.example.thankgodezeoffor.projectmeetingapp;
/**
 * AddActivityClass gets input from the user a
 * and adds the new attendee to the meeting list and database
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddAttendeesActivity extends AppCompatActivity implements View.OnClickListener {
    Button addAttendeesButton;
    private  String attendeeName;
    private  String attendeeEmail;

    Button closeAttendeeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendees);


        addAttendeesButton = findViewById(R.id.add_new_attendee_button);
        addAttendeesButton.setOnClickListener(this);

        closeAttendeeButton = findViewById(R.id.close_attendees_btn);
        closeAttendeeButton.setOnClickListener(this);

    }


    /**
     * This method checks if button has been clicked
     * and print a text saying when it has been clicked
     * and sends name/email to CreateMeetingActivity.class
     * and start the activity
     * @param v finds the first descendant view with the given ID
     */
    @Override
    public void onClick(View v) {
        if(v.equals(findViewById(R.id.add_new_attendee_button))){
            Toast.makeText(this, "attendee added", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, CreateNewMeetingActivity.class);
            intent.putExtra("name", attendeeName);
            intent.putExtra("email", attendeeEmail);
            startActivity(intent);

        }
       else if(v.equals(findViewById(R.id.close_attendees_btn))){
            Intent intent = new Intent(this, CreateNewMeetingActivity.class);
            startActivity(intent);
        }
    }
}
