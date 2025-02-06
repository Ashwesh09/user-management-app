package com.user.management.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "crypto")
class Crypto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coin;
    private String network;
    private String wallet;
}