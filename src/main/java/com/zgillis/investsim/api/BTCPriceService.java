package com.zgillis.investsim.api;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class BTCPriceService {

    public static final String COINDESK_URI = "https://api.coindesk.com/v1/bpi/currentprice/USD.json";

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public JSONObject getLatest() {
        ResponseEntity<String> res = restTemplate.exchange(COINDESK_URI, HttpMethod.GET, null, String.class);
        log.info("Made call to CoinDesk. Code={}; Msg={}", res.getStatusCodeValue(), res.getStatusCode().getReasonPhrase());
        JSONObject obj = new JSONObject(res.getBody());
        return obj;
    }
}
