package com.tareksaidee.bcconnected;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    RoomsAdapter(@NonNull Context context) {
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
        Room temp = roomsList.get(position);
        String name = temp.getName();
        holder.roomName.setText(name);
        if(!temp.isLocked())
            holder.lockedIcon.setVisibility(View.INVISIBLE);
        else
            holder.lockedIcon.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return roomsList.size();
    }

    void addRoom(Room room) {
        rooms.put(room.getName(), room);
        roomsList.add(room);
        notifyItemInserted(roomsList.size());
    }

    HashMap<String, Room> getRooms() {
        return (HashMap<String, Room>) rooms;
    }

    void clear() {
        rooms.clear();
        roomsList.clear();
    }

    void setUserName(String name) {
        mUserName = name;
    }

    class RoomsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final TextView roomName;
        ImageView lockedIcon;

        RoomsViewHolder(View view) {
            super(view);
            roomName = (TextView) view.findViewById(R.id.room_name);
            lockedIcon = (ImageView) view.findViewById(R.id.locked_icon);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            final Room temp = rooms.get(((TextView) view.findViewById(R.id.room_name)).getText().toString());
            if (temp.isLocked()) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Title");

                final EditText input = new EditText(mContext);
                input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                builder.setView(input);
                builder.setTitle("Enter Password");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (input.getText().toString().equals(temp.getPassword())){
                            Intent intent = new Intent(mContext, Chat.class);
                            intent.putExtra("room", temp.getName());
                            intent.putExtra("username", mUserName);
                            mContext.startActivity(intent);
                        }
                        else {
                            Toast.makeText(mContext, "Wrong Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            } else {
                Intent intent = new Intent(mContext, Chat.class);
                intent.putExtra("room", temp.getName());
                intent.putExtra("username", mUserName);
                mContext.startActivity(intent);
            }
        }
    }
}
