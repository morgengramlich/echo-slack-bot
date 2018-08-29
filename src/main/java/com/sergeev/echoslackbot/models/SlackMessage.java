package com.sergeev.echoslackbot.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;

public class SlackMessage implements Serializable {
    public String token;

    @JsonProperty("team_id")
    public String teamId;

    @JsonProperty("api_app_id")
    public String apiAppId;

    public EventData event;

    public String type;

    @JsonProperty("authed_users")
    public ArrayList<String> authedUsers;

    @JsonProperty("event_id")
    public String eventId;

    @JsonProperty("event_time")
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

    public EventData getEvent() {
        return event;
    }

    public void setEvent(EventData event) {
        this.event = event;
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
