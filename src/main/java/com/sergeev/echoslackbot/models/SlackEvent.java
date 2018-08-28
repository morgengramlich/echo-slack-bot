package com.sergeev.echoslackbot.models;

import java.util.ArrayList;

public class SlackEvent {
    public String token;
    public String teamId;
    public String apiAppId;
    public EventType eventType;
    public String type;
    public ArrayList<String> authedUsers;
    public String eventId;
    public long eventTime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getApiAppId() {
        return apiAppId;
    }

    public void setApiAppId(String apiAppId) {
        this.apiAppId = apiAppId;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getAuthedUsers() {
        return authedUsers;
    }

    public void setAuthedUsers(ArrayList<String> authedUsers) {
        this.authedUsers = authedUsers;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public long getEventTime() {
        return eventTime;
    }

    public void setEventTime(long eventTime) {
        this.eventTime = eventTime;
    }
}
