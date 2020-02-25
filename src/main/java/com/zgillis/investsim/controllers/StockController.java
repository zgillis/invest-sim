package com.zgillis.investsim.controllers;

import com.zgillis.investsim.entities.Stock;
import com.zgillis.investsim.repositories.StockRepository;
import com.zgillis.investsim.api.BTCPriceService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    BTCPriceService btcPriceService;

    @GetMapping("/all")
    public List<Stock> allStocks() {
        return stockRepository.findAll();
    }

    @GetMapping("/getbtc")
    public JSONObject getLatestBTCPrice() {
        org.json.JSONObject cd = btcPriceService.getLatest();
        JSONObject obj = new JSONObject();
        obj.put("currentPrice", cd.getJSONObject("bpi").getJSONObject("USD").getFloat("rate_float"));
        return obj;
    }

    @GetMapping("/{ticker}")
    public Stock getStockEntryByTicker(@PathVariable(name = "ticker") String ticker) {
        return stockRepository.findByTicker(ticker);
    }

}
