package com.example.stockquotemanager.services;

import com.example.stockquotemanager.models.Stock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StockManagerServiceTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    @Autowired
    StockManagerService stockManagerService;

    @Test
    public void testInvalidStock() {
        ResponseEntity<Stock[]> responseEntity = new ResponseEntity<>(new Stock[0], HttpStatus.OK);
        Mockito.when(restTemplate.getForEntity(anyString(), ArgumentMatchers.<Class<Stock[]>> any()))
                .thenReturn(responseEntity);

        Stock stock = new Stock("invalid-stock");

        assertFalse(stockManagerService.exists(stock));
        Mockito.verify(restTemplate).getForEntity(anyString(), ArgumentMatchers.<Class<Stock[]>> any());
    }

    @Test
    public void testValidStock() {
        ResponseEntity<Stock[]> responseEntity = new ResponseEntity<>(new Stock[]{new Stock("valid-stock")},
                HttpStatus.OK);
        Mockito.when(restTemplate.getForEntity(anyString(), ArgumentMatchers.<Class<Stock[]>> any()))
                .thenReturn(responseEntity);

        Stock stock = new Stock("valid-stock");

        assertTrue(stockManagerService.exists(stock));
        Mockito.verify(restTemplate).getForEntity(anyString(), ArgumentMatchers.<Class<Stock[]>> any());
    }

}
