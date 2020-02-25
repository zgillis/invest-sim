package com.zgillis.investsim.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.zgillis.investsim.entities.Stock.MAX_TICKER_LENGTH;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "price_history")
public class StockPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = MAX_TICKER_LENGTH, nullable = false)
    @JoinColumn(name = "ticker", table = "stocks")
    private String ticker;

    @Column(nullable = false, precision = 2)
    private Float price;

    @Column(nullable = false, precision = 2)
    private LocalDateTime updateTime;

}
