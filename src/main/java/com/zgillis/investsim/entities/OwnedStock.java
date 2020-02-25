package com.zgillis.investsim.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.zgillis.investsim.entities.Stock.MAX_TICKER_LENGTH;

@Entity
@Data
@NoArgsConstructor
public class OwnedStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Stock stock;

    @ManyToOne
    private UserAccount user;

    @Column(name = "share_qty")
    private Integer shareQty;

    @Column(name = "purchase_price_per_share")
    private Float purchasePrice;

    @Column(name = "purchase_ts")
    private LocalDateTime purchaseTS;

}
