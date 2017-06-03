package com.tareksaidee.bcconnected;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;

/**
 * Created by tarek on 5/30/2017.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    ArrayList<ChatMessage> messages;
    private Context mContext;

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
        ChatMessage message = messages.get(position);
        String name = message.getName();
        String text = message.getText();
        holder.userName.setText(name);
        if(message.getUserPhoto() != null) {
            Glide.with(holder.userImage.getContext())
                    .load(message.getUserPhoto())
                    .into(holder.userImage);
        }
        else
            holder.userImage.setImageResource(R.drawable.com_facebook_profile_picture_blank_square);
        boolean isPhoto = message.getPhotoUrl() != null;
        if (isPhoto) {
            holder.messageText.setVisibility(View.GONE);
            holder.photoImageView.setVisibility(View.VISIBLE);
            Glide.with(holder.photoImageView.getContext())
                    .load(message.getPhotoUrl())
                    .into(holder.photoImageView);
        }
        else{
            holder.messageText.setVisibility(View.VISIBLE);
            holder.photoImageView.setVisibility(View.GONE);
            holder.messageText.setText(text);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    void add(ChatMessage message){
        messages.add(message);
        notifyDataSetChanged();
    }

    void clear(){
        messages.clear();
    }

    class ChatViewHolder extends RecyclerView.ViewHolder {

        TextView userName;
        TextView messageText;
        PhotoView photoImageView;
        ImageView userImage;

        ChatViewHolder(View view){
            super(view);
            userName = (TextView) view.findViewById(R.id.nameTextView);
            messageText = (TextView) view.findViewById(R.id.messageTextView);
            photoImageView = (PhotoView) view.findViewById(R.id.photoImageView);
            userImage = (ImageView) view.findViewById(R.id.user_image);
        }
    }


}
