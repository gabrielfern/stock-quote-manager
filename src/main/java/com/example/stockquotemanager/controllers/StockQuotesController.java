package com.example.stockquotemanager.controllers;

import com.example.stockquotemanager.dto.StockQuoteDTO;
import com.example.stockquotemanager.models.StockQuote;
import com.example.stockquotemanager.models.Stock;
import com.example.stockquotemanager.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stockquotes")
public class StockQuotesController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<StockQuoteDTO> getAllStockQuotes() {
        return stockService.getAll().stream()
            .map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StockQuoteDTO> getStockQuote(@PathVariable("id") String stockId) {
        Stock stock = stockService.get(stockId);

        if (stock != null) {
            return new ResponseEntity<>(this.convertToDTO(stock), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public void addStockQuote(@RequestBody StockQuoteDTO stockQuoteDTO) {
        stockService.add(this.convertToEntity(stockQuoteDTO));
    }

    private Stock convertToEntity(StockQuoteDTO stockQuoteDTO) {
        Stock stock = new Stock(stockQuoteDTO.getId());

        if (stockQuoteDTO.getQuotes() != null) {
            for (Map.Entry<LocalDate, Double> entry : stockQuoteDTO.getQuotes().entrySet()) {
                stock.getQuotes().add(new StockQuote(entry.getKey(), entry.getValue()));
            }
        }

        return stock;
    }

    private StockQuoteDTO convertToDTO(Stock stock) {
        StockQuoteDTO stockQuoteDTO = new StockQuoteDTO(stock.getId());

        for (StockQuote stockQuote : stock.getQuotes()) {
            stockQuoteDTO.getQuotes().put(stockQuote.getDate(), stockQuote.getPrice());
        }

        return stockQuoteDTO;
    }

}
