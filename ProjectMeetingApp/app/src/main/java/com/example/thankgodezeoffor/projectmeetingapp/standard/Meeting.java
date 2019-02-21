package com.example.thankgodezeoffor.projectmeetingapp.standard;

import java.util.ArrayList;
import java.util.Date;

public class Meeting {

    //setting useful final variables
    public  static  final String ID = "id";
    public static final String TITLE = "title";
    public static final String DATE = "date";
    public static final String TIME = "time";
    public static final String NOTES = "notes";
    public static final String ATTENDEES = "attendees";
    public static final String LOCATION = "location";



    private int id; //meeting ID
    private String meetingTitle; //Title of meeting
    private Date meetingDate; //Date of meeting
    private String meetingNotes; //Meeting notes
    private int [] meetingLocation = new int[]{0,0}; //Location of meeting
    private ArrayList<Integer> attendees; //Meeting attendees


    public static String getID() {
        return ID;
    }

    public static String getTITLE() {
        return TITLE;
    }

    public static String getDATE() {
        return DATE;
    }

    public static String getTIME() {
        return TIME;
    }

    public static String getNOTES() {
        return NOTES;
    }

    public static String getATTENDEES() {
        return ATTENDEES;
    }

    public static String getLOCATION() {
        return LOCATION;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getMeetingNotes() {
        return meetingNotes;
    }

    public void setMeetingNotes(String meetingNotes) {
        this.meetingNotes = meetingNotes;
    }

    public int[] getMeetingLocation() {
        return meetingLocation;
    }

    public void setMeetingLocation(int[] meetingLocation) {
        this.meetingLocation = meetingLocation;
    }

    public ArrayList<Integer> getAttendees() {
        return attendees;
    }

    public void setAttendees(ArrayList<Integer> attendees) {
        this.attendees = attendees;
    }
}
