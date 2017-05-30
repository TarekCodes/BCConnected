package com.tareksaidee.bcconnected;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tarek on 5/29/2017.
 */

public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.RoomsViewHolder> {

    private final Context mContext;
    Map<String, String> rooms;
    ArrayList<String> roomsList;

    RoomsAdapter(@NonNull Context context){
        mContext = context;
        rooms = new HashMap<>();
        roomsList = new ArrayList<>();
    }

    @Override
    public RoomsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rooms_list_layout, parent, false);
        return new RoomsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RoomsViewHolder holder, int position) {
        String name = roomsList.get(position);
        holder.roomName.setText(name);
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    void addRoom(String name){
        rooms.put(name,name);
        roomsList.add(name);
        notifyDataSetChanged();
    }

    HashMap<String, String> getRooms(){
        return (HashMap<String,String>) rooms;
    }

    void clear(){
        rooms.clear();
        roomsList.clear();
    }

    class RoomsViewHolder extends RecyclerView.ViewHolder {

        final TextView roomName;

        RoomsViewHolder(View view){
            super(view);
            roomName = (TextView) view.findViewById(R.id.room_name);
        }
    }
}
