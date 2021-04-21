package com.example.stockquotemanager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StartupRunner implements ApplicationRunner {

    @Value("${STOCK_QUOTE_MANAGER_HOST:localhost}")
    private String stockQuoteManagerHost;

    @Value("${STOCK_MANAGER_HOST:localhost}")
    private String stockManagerHost;

    @Override
    public void run(ApplicationArguments args) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String body = "{\"host\":\"" + stockQuoteManagerHost +
                "\",\"port\":8081}";

        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        restTemplate.postForEntity("http://" + stockManagerHost + ":8080/notification", entity, String.class);
    }

}
