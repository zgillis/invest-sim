package com.zgillis.investsim.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "financial_accounts")
public class FinancialAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = UserAccount.class, cascade = CascadeType.DETACH)
    private UserAccount userAccount;

    private Float balance;
    private LocalDateTime created;
    private LocalDateTime modified;
    private boolean closed;
}
