package com.example.stockquotemanager.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Stock {

    @Id
    private String id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "stock_id")
    private List<StockQuote> stockQuotes;

    public Stock() {
        this.stockQuotes = new ArrayList<>();
    }

    public Stock(String id) {
        this.id = id;
        this.stockQuotes = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<StockQuote> getQuotes() {
        return stockQuotes;
    }

}
