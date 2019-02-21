package com.example.thankgodezeoffor.projectmeetingapp;

/**
 * GetStarted is a page that has only one functionality
 * It has a button that when clicked
 * goes to the MainActivity
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class GetStarted extends AppCompatActivity implements View.OnClickListener {

    Button getStartedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        //sets declarations
        getStartedBtn = findViewById(R.id.get_started_btn);
        getStartedBtn.setOnClickListener(this);
    }

    /**
     * Checks when button is clicked
     * if button is clicked go to MainActivity.class
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (v.equals(findViewById(R.id.get_started_btn))) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}