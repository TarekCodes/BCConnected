package com.tareksaidee.bcconnected;

import android.content.Context;
import android.content.Intent;
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
    Map<String, Room> rooms;
    ArrayList<Room> roomsList;
    String mUserName;

    RoomsAdapter(@NonNull Context context){
        mContext = context;
        rooms = new HashMap<>();
        roomsList = new ArrayList<>();
        mUserName = null;
    }

    @Override
    public RoomsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rooms_list_item, parent, false);
        return new RoomsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RoomsViewHolder holder, int position) {
        String name = roomsList.get(position).getName();
        holder.roomName.setText(name);
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    void addRoom(Room room){
        rooms.put(room.getName(),room);
        roomsList.add(room);
        notifyDataSetChanged();
    }

    HashMap<String, Room> getRooms(){
        return (HashMap<String,Room>) rooms;
    }

    void clear(){
        rooms.clear();
        roomsList.clear();
    }

    void setUserName(String name){
        mUserName = name;
    }

    class RoomsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final TextView roomName;

        RoomsViewHolder(View view){
            super(view);
            roomName = (TextView) view.findViewById(R.id.room_name);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, Chat.class);
            intent.putExtra("room", ((TextView) view.findViewById(R.id.room_name)).getText().toString());
            intent.putExtra("username", mUserName);
            mContext.startActivity(intent);
        }
    }
}
