package com.user.management.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bank")
class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardExpire;
    private String cardNumber;
    private String cardType;
    private String currency;
    private String iban;
}