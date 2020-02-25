package com.zgillis.investsim.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "stocks")
public class Stock {

    public static final int MAX_TICKER_LENGTH = 6;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = MAX_TICKER_LENGTH)
    private String ticker;

    @Column(length = 35)
    private String name;

    @Enumerated(EnumType.STRING)
    private StockType type;

    private Boolean monitored = true;

    public enum StockType {
        STOCK, CRYPTO, FOREX, OTHER
    }

}
