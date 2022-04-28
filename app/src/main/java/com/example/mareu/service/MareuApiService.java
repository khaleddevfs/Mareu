package com.example.mareu.service;

import com.example.mareu.Model.Meeting;

import java.util.List;

public interface MareuApiService {


        List<Meeting> getMeetings();

        List<Meeting> getMeetingsListFiltered();

        void addMeeting(Meeting meeting);

        void deleteMeeting(Meeting meeting);

    }

