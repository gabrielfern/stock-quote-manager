package com.example.stockquotemanager.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class StockQuote {

    @Id
    @GeneratedValue
    private long id;
    private LocalDate date;
    private Double price;

    public StockQuote() {
    }

    public StockQuote(LocalDate date, double price) {
        this.date = date;
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getPrice() {
        return price;
    }

}
