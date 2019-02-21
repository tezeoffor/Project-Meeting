package com.example.thankgodezeoffor.projectmeetingapp.standard;

public class Attendee {

    public static final String ID = "ID";
    public static final String NAME = "name";
    public static final String EMAIL = "email";

    public static final String TABLE = "attendees";

    //Different attribute for attendees
    private  String fullNameOfAttendee;
    private  String emailAttendee;
    private  int attendeeID;

    public String getFullNameOfAttendee() {
        return fullNameOfAttendee;
    }

    public void setFullNameOfAttendee(String fullNameOfAttendee) {
        this.fullNameOfAttendee = fullNameOfAttendee;
    }

    public String getEmailAttendee() {
        return emailAttendee;
    }

    public void setEmailAttendee(String emailAttendee) {
        this.emailAttendee = emailAttendee;
    }

    public int getAttendeeID() {
        return attendeeID;
    }

    public void setAttendeeID(int attendeeID) {
        this.attendeeID = attendeeID;
    }
}
