package com.zgillis.investsim.repositories;

import com.zgillis.investsim.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
    public Stock findByTicker(String ticker);
}
