package com.tareksaidee.bcconnected;

/**
 * Created by tarek on 5/30/2017.
 */

public class ChatMessage {
    private String text;
    private String name;

    ChatMessage() {
    }

    ChatMessage(String text, String name) {
        this.text = text;
        this.name = name;
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
}
