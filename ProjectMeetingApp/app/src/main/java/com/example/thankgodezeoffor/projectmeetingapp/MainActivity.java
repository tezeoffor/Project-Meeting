package com.example.thankgodezeoffor.projectmeetingapp;

/**
 * MainActivity displays the meeting list
 * and has a button that when clicked
 * goes to CreateNewMeeting.class and
 * creates a new meeting
 */

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     //Button declarations
    ImageButton createNewMeetingBtn;

    //List of user meetings declared
    private ArrayList<HashMap<String, String>> listOfMeeting;
    private ListView listView;

    DatabaseHelper mDatabaseHelper;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("GetStarted", "Get Started view");

        Log.d("MainActivity", "MainActivity view");

        listView = (ListView) findViewById(R.id.listview);
        mDatabaseHelper = new DatabaseHelper(this);

        //Create button definition
        createNewMeetingBtn = (findViewById(R.id.create_button));
        createNewMeetingBtn.setOnClickListener(this);



    }

     /**
      * This method checks if button has been clicked
      * if button is clicked
      * starts the next activity
      * @param view
      */
    public void onClick (View view){
        if(view.equals(findViewById(R.id.create_button))){
            //TODO: Remove after final testing
            Toast.makeText(this,"create button clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, CreateNewMeetingActivity.class);
            startActivity(intent);
        }
    }
}
