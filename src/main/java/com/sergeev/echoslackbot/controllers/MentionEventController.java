package com.sergeev.echoslackbot.controllers;

import com.sergeev.echoslackbot.models.SlackMessage;
import com.sergeev.echoslackbot.services.api.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class MentionEventController {

    @Autowired
    ResponseService responseService;

    @RequestMapping(value = "/mention", method = RequestMethod.POST, consumes="application/json")
    @ResponseStatus(HttpStatus.OK)
    public void postMention(@RequestBody SlackMessage event) {
        if (event.getEvent().getBotId() == null) {
            responseService.sendResponse(event);
        }
    }

}
