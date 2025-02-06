package com.user.management.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String city;
    private String state;
    private String stateCode;
    private String country;
    private String postalCode;

    @OneToOne(cascade = CascadeType.ALL)
    private Coordinates coordinates;
}