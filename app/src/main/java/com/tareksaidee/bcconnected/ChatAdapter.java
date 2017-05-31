package com.tareksaidee.bcconnected;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tarek on 5/30/2017.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    ArrayList<ChatMessage> messages;
    Context mContext;

    ChatAdapter(@NonNull Context context){
        mContext = context;
        messages = new ArrayList<>();
    }

    @Override
    public ChatAdapter.ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.message_item, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ChatViewHolder holder, int position) {
        String name = messages.get(position).getName();
        String text = messages.get(position).getText();
        holder.messageText.setText(text);
        holder.userName.setText(name);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    void add(ChatMessage message){
        Log.e("size", messages.size()+"");
        messages.add(message);
        notifyDataSetChanged();
    }

    void clear(){
        messages.clear();
    }

    class ChatViewHolder extends RecyclerView.ViewHolder {

        TextView userName;
        TextView messageText;

        ChatViewHolder(View view){
            super(view);
            userName = (TextView) view.findViewById(R.id.nameTextView);
            messageText = (TextView) view.findViewById(R.id.messageTextView);
        }
    }


}
