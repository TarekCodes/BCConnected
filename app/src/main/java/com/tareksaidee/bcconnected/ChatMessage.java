package com.tareksaidee.bcconnected;

/**
 * Created by tarek on 5/30/2017.
 */

public class ChatMessage {
    private String text;
    private String name;
    private String photoUrl;
    private String userPhoto;


    ChatMessage() {
    }

    ChatMessage(String text, String name, String photoUrl, String userPhoto) {
        this.text = text;
        this.name = name;
        this.photoUrl = photoUrl;
        this.userPhoto = userPhoto;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setUserPhoto(String userPhoto){
        this.userPhoto = userPhoto;
    }

    public String getUserPhoto(){
        return userPhoto;
    }

}
