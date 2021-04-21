package com.example.stockquotemanager.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stockquotes")
public class StockQuotesController {

    @GetMapping
    public String getAllStockQuotes() {
        return "Work in progress\n";
    }
}
