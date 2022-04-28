package com.example.mareu.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.Model.Meeting;
import com.example.mareu.databinding.ListItemsBinding;

import java.util.List;


public class MeetingRecyclerViewAdapter extends RecyclerView.Adapter<MeetingRecyclerViewAdapter.ViewHolder>{

    private final List<Meeting> mMeeting;
    ListItemsBinding binding;
    private Object GradientDrawable;

    public MeetingRecyclerViewAdapter(List<Meeting> mMeeting) {
        this.mMeeting = mMeeting;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(ListItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(MeetingRecyclerViewAdapter.ViewHolder holder, final int position) {
        Meeting meeting = mMeeting.get(position);
        Context context = binding.getRoot().getContext();
        Activity activity = (Activity) context;
        GradientDrawable circle = new GradientDrawable();
        circle.setColor(meeting.getColor());
        holder.binding.colorCircle.setBackground(circle);
        holder.binding.meetingDescription.setText(meeting.getMeetingName());
        holder.binding.meetingMembers.setText(meeting.getMeetingMembers());
        holder.binding.deleteMeetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMeeting.remove(meeting);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMeeting == null  ? 0 :
                mMeeting.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ListItemsBinding binding;

        public ViewHolder(ListItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}