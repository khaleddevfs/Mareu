package com.example.mareu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.Injector.DI;
import com.example.mareu.Model.Meeting;
import com.example.mareu.R;
import com.example.mareu.databinding.ActivityListMeetingBinding;
import com.example.mareu.service.MareuApiService;

import java.util.Arrays;
import java.util.List;

import static com.example.mareu.service.MareuApiServiceGenerator.Meetings;


public class ListMeetingActivity extends AppCompatActivity {
    private ActivityListMeetingBinding binding;
    private MareuApiService apiService;
    Toolbar mToolbar;
    RecyclerView recyclerView;
    MeetingRecyclerViewAdapter meetingRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListMeetingBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_list_meeting);
        View view = binding.getRoot();
        setContentView(view);
        setSupportActionBar(mToolbar);
        recyclerView = binding.meetingList;
        apiService = DI.getMareuApiService();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.meetingList.setLayoutManager(layoutManager);
        //MeetingRecyclerViewAdapter meetingRecyclerViewAdapter = new MeetingRecyclerViewAdapter();
        recyclerView.setAdapter(meetingRecyclerViewAdapter);
        List<Meeting> meetingList = Arrays.asList(meetingList);
        binding.meetingList.setAdapter(new MeetingRecyclerViewAdapter(meetingList));
        binding.appbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.meetingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(String.valueOf(meetingList), "View Binding press");

            }
        });

        binding.addMeetFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListMeetingActivity.this, AddMeetingActivity.class);
                startActivity(intent);
            }
        });

        binding.filterImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void setAdapter(List<Meeting> meetingList) {
        meetingRecyclerViewAdapter = new MeetingRecyclerViewAdapter(meetingList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(meetingRecyclerViewAdapter);

    }
}