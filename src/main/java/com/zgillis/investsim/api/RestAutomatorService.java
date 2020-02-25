package com.zgillis.investsim.api;

import com.zgillis.investsim.entities.StockPrice;
import com.zgillis.investsim.repositories.StockPriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@EnableScheduling
@Service
public class RestAutomatorService {

    @Autowired
    BTCPriceService btcPriceService;

    @Autowired
    StockPriceService stockPriceService;

    @Autowired
    StockPriceRepository stockPriceRepository;

    @Scheduled(fixedDelayString = "${investsim.updaterate.bitcoin:60000}")
    public void fetchLatestBitcoin() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        JSONObject latest = btcPriceService.getLatest();
        StockPrice price = StockPrice.builder()
                .price(latest.getJSONObject("bpi").getJSONObject("USD").getFloat("rate_float"))
                .ticker("BTC")
                .updateTime(currentDateTime)
                .build();
        stockPriceRepository.save(price);
        log.info("Saved latest BTC price ($US {}) at {}.", price.getPrice(), price.getUpdateTime());
    }

    @Scheduled(fixedDelayString = "1800000")
    public void fetchLatestStocks() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Float latest = stockPriceService.getStockPrice("TSLA");
        StockPrice price = StockPrice.builder()
                .price(latest)
                .ticker("TSLA")
                .updateTime(currentDateTime)
                .build();
        stockPriceRepository.save(price);
        log.info("Saved latest BTC price ($US {}) at {}.", price.getPrice(), price.getUpdateTime());
    }

}
