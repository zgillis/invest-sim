package com.zgillis.investsim.api;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@EnableScheduling
public class StockPriceService {

    @Value("${stocks.api.key:none}")
    private String apiKey;

    @Autowired
    RestTemplate restTemplate;

    public Float getStockPrice(String ticker) {
        ResponseEntity<String> res = restTemplate.exchange("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol="
                + ticker + "&apikey=RA3MEL2DG6O9ZJ8T", HttpMethod.GET, null, String.class);
        return Float.parseFloat(new JSONObject(res.getBody()).getJSONObject("Global Quote").getString("05. price"));
    }

}
