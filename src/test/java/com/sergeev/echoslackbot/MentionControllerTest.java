package com.sergeev.echoslackbot;

import com.sergeev.echoslackbot.controllers.MentionController;
import com.sergeev.echoslackbot.services.api.ResponseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MentionController.class, secure = false)
public class MentionControllerTest {
    private static final String MOCK_CHALLENGE = "test";
    private static final String VERIFICATION_JSON = "{\"challenge\":\"" + MOCK_CHALLENGE + "\"}";
    private static final String MENTION_JSON = "{\"event\":{}}";
    private static final String SELF_MENTION_JSON = "{\"event\":{\"bot_id\":\"test\"}}";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ResponseService responseService;

    @Test
    public void respondToMention() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/mention")
                .contentType(MediaType.APPLICATION_JSON)
                .content(MENTION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void ignoreSelfMention() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/mention")
                .contentType(MediaType.APPLICATION_JSON)
                .content(SELF_MENTION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void respondToVerification() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/mention")
                .contentType(MediaType.APPLICATION_JSON)
                .content(VERIFICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertThat(response.getContentAsString()).isEqualTo(MOCK_CHALLENGE);
    }

}
