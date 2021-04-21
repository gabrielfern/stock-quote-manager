package com.example.stockquotemanager.services;

import com.example.stockquotemanager.models.Stock;
import com.example.stockquotemanager.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

    public Stock get(String id) {
        return stockRepository.findById(id).orElse(null);
    }

    public Stock add(Stock stock) {
        return stockRepository.save(stock);
    }

}
