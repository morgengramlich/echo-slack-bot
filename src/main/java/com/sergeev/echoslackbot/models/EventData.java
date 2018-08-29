package com.sergeev.echoslackbot.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class EventData implements Serializable {
    private String type;
    private String user;
    private String text;
    private String ts;
    private String channel;

    @JsonProperty("client_msg_id")
    private String clientMsgId;

    @JsonProperty("event_ts")
    private String eventTs;

    @JsonProperty("bot_id")
    private String botId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getClientMsgId() {
        return clientMsgId;
    }

    public void setClientMsgId(String clientMsgId) {
        this.clientMsgId = clientMsgId;
    }

    public String getEventTs() {
        return eventTs;
    }

    public void setEventTs(String eventTs) {
        this.eventTs = eventTs;
    }

    public String getBotId() {
        return botId;
    }

    public void setBotId(String botId) {
        this.botId = botId;
    }
}
