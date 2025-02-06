package com.user.management.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "company")
class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String department;
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}