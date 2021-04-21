package com.example.stockquotemanager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StartupRunner implements ApplicationRunner {

    @Value("${HOST}")
    private String host;

    @Override
    public void run(ApplicationArguments args) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String body = "{\"host\":\"" + host +
                "\",\"port\":8081}";

        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        restTemplate.postForEntity("http://localhost:8080/notification", entity, String.class);
    }

}
