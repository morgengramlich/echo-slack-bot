package com.sergeev.echoslackbot.services.implementation;

import com.sergeev.echoslackbot.models.SimpleResponse;
import com.sergeev.echoslackbot.models.SlackMessage;
import com.sergeev.echoslackbot.services.api.ResponseService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class EchoResponseServiceImpl implements ResponseService {
    private final ExecutorService cachedPool = Executors.newCachedThreadPool();

    private final static String AUTHORIZATION_HEADER = "Authorization";
    private final static String AUTHORIZATION_VALUE = "Bearer ";
    private final static String BOT_TOKEN = "xoxb-423433231557-424627667862-oEg0PYe2Z5ilj9Lf7eAvUBkZ";
    private final static String SLACK_ENDPOINT_URL = "https://slack.com/api/chat.postMessage";
    private final static String RESPONSE_PREFIX = "Вы сказали: ";

    @Override
    public void sendResponse(SlackMessage inMessage) {
        cachedPool.submit(() -> {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set(AUTHORIZATION_HEADER, AUTHORIZATION_VALUE + BOT_TOKEN);

            SimpleResponse response = new SimpleResponse();
            response.setText(RESPONSE_PREFIX + inMessage.getEvent().getText());
            response.setChannel(inMessage.getEvent().getChannel());

            HttpEntity<SimpleResponse> postResponse = new HttpEntity<>(response, headers);
            new RestTemplate().postForLocation(SLACK_ENDPOINT_URL, postResponse);
        });
    }
}
