package com.example.stockquotemanager.services;

import com.example.stockquotemanager.models.Stock;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockManagerService {

    public boolean exists(Stock stock) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Stock[]> resp = restTemplate.getForEntity("http://localhost:8080/stock", Stock[].class);
        Stock[] stocks = resp.getBody();

        if (stocks != null) {
            for (Stock currStock : stocks) {
                if (stock.getId().equals(currStock.getId()))
                    return true;
            }
        }

        return false;
    }

}
