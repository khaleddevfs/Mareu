package com.example.mareu.service;

import com.example.mareu.Model.Meeting;

import java.util.ArrayList;
import java.util.List;

public class MeetingApiServiceRepository implements MareuApiService {

    private List<Meeting> meetings = MareuApiServiceGenerator.generateMeetings();
    private List<Meeting> mMeetingsListFiltered = new ArrayList<>(meetings);

    @Override
    public List<Meeting> getMeetings() {
        return meetings;
    }

    @Override
    public List<Meeting> getMeetingsListFiltered() {
        return mMeetingsListFiltered;
    }

    @Override
    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);

    }

    @Override
    public void deleteMeeting(Meeting meeting) {
        meetings.remove(meeting);

    }
}
