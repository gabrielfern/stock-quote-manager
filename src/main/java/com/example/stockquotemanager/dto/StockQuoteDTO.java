package com.example.stockquotemanager.dto;

import java.time.LocalDate;
import java.util.HashMap;

public class StockQuoteDTO {
    private String id;
    private HashMap<LocalDate, Double> quotes;

    public StockQuoteDTO() {
    }

    public StockQuoteDTO(String id) {
        this.id = id;
        this.quotes = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public HashMap<LocalDate, Double> getQuotes() {
        return quotes;
    }
}
