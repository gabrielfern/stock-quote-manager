package com.example.stockquotemanager.controllers;

import com.example.stockquotemanager.services.StockManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stockcache")
public class StockCacheController {

    @Autowired
    private StockManagerService stockManagerService;

    @DeleteMapping
    public void clearCache() {
        stockManagerService.populateCache();
    }

}
