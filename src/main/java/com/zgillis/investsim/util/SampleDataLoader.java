package com.zgillis.investsim.util;

import com.zgillis.investsim.entities.Stock;
import com.zgillis.investsim.entities.StockPrice;
import com.zgillis.investsim.entities.UserAccount;
import com.zgillis.investsim.repositories.StockPriceRepository;
import com.zgillis.investsim.repositories.StockRepository;
import com.zgillis.investsim.repositories.UserAccountRepository;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Slf4j
@RequestMapping("/util")
@RestController
public class SampleDataLoader {

    @Autowired
    StockRepository stockRepository;
    @Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    StockPriceRepository stockPriceRepository;

    @GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject insertDummyData(HttpServletResponse response) {
        JSONObject obj = new JSONObject();
        try {
            stockRepository.save(Stock.builder().ticker("KSS").type(Stock.StockType.STOCK).name("Kohl's Department Stores").build());
            stockRepository.save(Stock.builder().ticker("WMT").type(Stock.StockType.STOCK).name("Walmart").build());
            stockRepository.save(Stock.builder().ticker("BTC").type(Stock.StockType.CRYPTO).name("Bitcoin").build());
            userAccountRepository.save(UserAccount.builder()
                    .username("testuser")
                    .password("testpassword")
                    .firstName("Robert")
                    .lastName("Sagat")
                    .email("bsagat@mailinator.com")
                    .phone("6087336473").build());
            stockPriceRepository.save(StockPrice.builder()
                .ticker("BTC")
                .price(9385.32f)
                .updateTime(LocalDateTime.now())
                .build());
            obj.put("status", 200);
            obj.put("message", "dummy data inserted");
            obj.put("user", userAccountRepository.getOne(1L));
            return obj;
        } catch (Exception e) {
            log.error("Error inserting dummy data: {}", e.getMessage());
            log.debug("{}", e);
            obj.put("status", 500);
            obj.put("message", e.getMessage());
            return obj;
        }
    }
}
