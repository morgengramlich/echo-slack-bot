package com.sergeev.echoslackbot.controllers;

import com.sergeev.echoslackbot.models.SlackMessage;
import com.sergeev.echoslackbot.services.api.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MentionEventController {

    @Autowired
    ResponseService responseService;

    @RequestMapping(value = "/mention", method = RequestMethod.POST, consumes="application/json")
    public String postMention(@RequestBody SlackMessage event) {
        if (event.getChallenge() != null) {
            return event.getChallenge();
        } else if (event.getEvent().getBotId() == null) {
            responseService.sendResponse(event);
        }
        return "";
    }

}
