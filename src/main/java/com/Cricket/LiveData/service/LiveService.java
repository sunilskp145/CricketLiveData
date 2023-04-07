package com.Cricket.LiveData.service;

import com.Cricket.LiveData.response.LiveResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class LiveService {
    @Value("${Url}")
    private String cricketUrl;

    @Value("${apiKey}")
    private String key;

    @Value("${hostKey}")
    private String hostKey;

    public LiveResponse getResponse(){

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", key);
        headers.set("X-RapidAPI-Host",hostKey);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<LiveResponse> response = new RestTemplate().exchange(cricketUrl, HttpMethod.GET, entity, LiveResponse.class);
        LiveResponse responseBody = response.getBody();

        return responseBody;


    }
}
