package com.zgillis.investsim.repositories;

import com.zgillis.investsim.entities.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
}
