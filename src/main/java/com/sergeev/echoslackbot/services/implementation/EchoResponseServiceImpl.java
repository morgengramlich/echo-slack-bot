package com.sergeev.echoslackbot.services.implementation;

import com.sergeev.echoslackbot.BotProperties;
import com.sergeev.echoslackbot.models.SimpleResponse;
import com.sergeev.echoslackbot.models.SlackMessage;
import com.sergeev.echoslackbot.services.api.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
    private final static String REST_METHOD = "chat.postMessage";
    private final static String RESPONSE_PREFIX = "Вы сказали: ";

    @Autowired
    BotProperties properties;

    @Override
    public void sendResponse(SlackMessage inMessage) {
        cachedPool.submit(() -> {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set(AUTHORIZATION_HEADER, AUTHORIZATION_VALUE + properties.getToken());

            SimpleResponse response = new SimpleResponse();
            response.setText(RESPONSE_PREFIX + inMessage.getEvent().getText());
            response.setChannel(inMessage.getEvent().getChannel());

            HttpEntity<SimpleResponse> postResponse = new HttpEntity<>(response, headers);
            new RestTemplate().postForLocation(properties.getEndpoint() + REST_METHOD, postResponse);
        });
    }
}
