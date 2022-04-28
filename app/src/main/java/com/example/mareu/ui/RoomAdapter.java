package com.example.mareu.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mareu.Model.Room;
import com.example.mareu.R;

import java.util.List;

public class RoomAdapter extends BaseAdapter {

    private Context context;
    private List<Room> roomList;

    public RoomAdapter(Context context, List<Room> fruitList) {
        this.context = context;
        this.roomList = fruitList;
    }

    @Override
    public int getCount() {
        return roomList != null ? roomList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.room_items, viewGroup, false);

        TextView txtName = rootView.findViewById(R.id.name);
        ImageView image = rootView.findViewById(R.id.image);

        txtName.setText(roomList.get(i).getName());
        image.setImageResource(roomList.get(i).getImage());

        return rootView;
    }
}
