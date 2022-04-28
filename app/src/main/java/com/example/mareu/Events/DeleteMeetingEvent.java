package com.example.mareu.Events;

import com.example.mareu.Model.Meeting;

/**
 * Event fired when a user deletes a Neighbour
 */
public class DeleteMeetingEvent {

    /**
     * Neighbour to delete
     */
    public Meeting meeting;

    /**
     * Constructor.
     * @param meeting
     */
    public DeleteMeetingEvent(Meeting meeting)   {
        this.meeting = meeting;
    }
}
