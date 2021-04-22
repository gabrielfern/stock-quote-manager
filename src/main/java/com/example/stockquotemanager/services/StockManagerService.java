package com.example.stockquotemanager.services;

import com.example.stockquotemanager.models.Stock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockManagerService {

    @Value("${STOCK_MANAGER_HOST:localhost}")
    private String stockManagerHost;

    private Stock[] stocksCache;

    RestTemplate restTemplate = new RestTemplate();

    public boolean exists(Stock stock) {
        if (stocksCache == null)
            this.populateCache();

        if (stocksCache != null) {
            for (Stock currStock : stocksCache) {
                if (stock.getId().equals(currStock.getId()))
                    return true;
            }
        }

        return false;
    }

    public void populateCache() {
        ResponseEntity<Stock[]> resp = restTemplate.getForEntity("http://" + stockManagerHost + ":8080/stock",
                Stock[].class);
        stocksCache = resp.getBody();
    }

}
