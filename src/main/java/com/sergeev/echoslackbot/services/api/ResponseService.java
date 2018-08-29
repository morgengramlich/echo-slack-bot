package com.sergeev.echoslackbot.services.api;

import com.sergeev.echoslackbot.models.SlackMessage;

public interface ResponseService {
    public void sendResponse(SlackMessage inMessage);
}
