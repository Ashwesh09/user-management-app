package com.user.management.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "coordinates")
class Coordinates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double lat;
    private double lng;
}