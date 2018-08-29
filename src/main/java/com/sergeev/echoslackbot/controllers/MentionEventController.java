package com.sergeev.echoslackbot.controllers;

import com.sergeev.echoslackbot.models.SlackMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MentionEventController {

    @RequestMapping(value = "/mention", method = RequestMethod.POST, consumes="application/json")
    public String postMention(@RequestBody SlackMessage event) {
        return  event.getEvent().getText();
    }

}
