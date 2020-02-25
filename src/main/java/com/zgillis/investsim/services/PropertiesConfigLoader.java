package com.zgillis.investsim.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Cacheable;

@Getter
@Cacheable
@Configuration
public class PropertiesConfigLoader {

    @Value("${nexo.investor-sim.site-name:blank}")
    private String siteName;

}
