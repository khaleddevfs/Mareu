package com.example.mareu.Model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Meeting implements Parcelable {

    private final int MeetingColor;

    private String MeetingName;

    private String MeetingTime;

    private String MeetingPlace;

    private String MeetingDate;

    private String MeetingMembers;



    public Meeting(int MeetingColor, String MeetingName, String MeetingTime, String MeetingPlace, String MeetingDate, String MeetingMembers){

        this.MeetingColor = MeetingColor;
        this.MeetingName= MeetingName;
        this.MeetingTime= MeetingTime;
        this.MeetingPlace= MeetingPlace;
        this.MeetingDate= MeetingDate;
        this.MeetingMembers = MeetingMembers;



    }

    protected Meeting(Parcel in) {
        MeetingColor = in.readInt();
        MeetingName = in.readString();
        MeetingTime = in.readString();
        MeetingPlace = in.readString();
        MeetingDate = in.readString();
        MeetingMembers = in.readString();
    }

    public static final Creator<Meeting> CREATOR = new Creator<Meeting>() {
        @Override
        public Meeting createFromParcel(Parcel in) {
            return new Meeting(in);
        }

        @Override
        public Meeting[] newArray(int size) {
            return new Meeting[size];
        }
    };

    public int getColor() {
        return MeetingColor;
    }


    public String getMeetingName() {
        return MeetingName;
    }

    public void setMeetingName(String meetingName) {
        MeetingName = meetingName;
    }

    public String getMeetingTime() {
        return MeetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        MeetingTime = meetingTime;
    }

    public String getMeetingPlace() {
        return MeetingPlace;
    }

    public void setMeetingPlace(String meetingPlace) {
        MeetingPlace = meetingPlace;
    }

    public String getMeetingDate() { return MeetingDate; }

    public void setMeetingDate(String meetingDate) { MeetingDate = meetingDate; }

    public String getMeetingMembers() {
        return MeetingMembers;
    }

    public void setMeetingMembers(String meetingMembers) {
        MeetingMembers = meetingMembers;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(MeetingColor);
        dest.writeString(MeetingName);
        dest.writeString(MeetingTime);
        dest.writeString(MeetingPlace);
        dest.writeString(MeetingDate);
        dest.writeString(MeetingMembers);


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(MeetingColor, meeting.MeetingColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MeetingColor);
    }
}






