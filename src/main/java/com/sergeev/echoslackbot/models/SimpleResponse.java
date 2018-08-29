package com.sergeev.echoslackbot.models;

import java.io.Serializable;

public class SimpleResponse implements Serializable {
    private String channel;
    private String text;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
