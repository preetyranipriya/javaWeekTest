package com.example.offlinePayment.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="wallet_table")

public class Wallet {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

    int walletId;
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    private Double balance;
    private Double offlineBalance;

    @ElementCollection
    @CollectionTable(name = "wallet_codes", joinColumns = @JoinColumn(name = "wallet_id"))
    @Column(name = "code")
    @Builder.Default
    private Set<String> codes = new HashSet<>();
    public Wallet(User user)
    {
        this.user=user;
        this.balance = Double.valueOf(0);
        this.offlineBalance = Double.valueOf(0);
    }
    public Wallet() {
        this.setBalance(Double.valueOf(0));
        this.setOfflineBalance(Double.valueOf(0));
    }
    public Wallet(int walletId)
    {
        this.walletId=walletId;

    }



}
