package com.user.management.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

@Data
@Entity
@Table(name = "users")
@Indexed
public class User {
    @Id
    private Long id;
    @FullTextField
    private String firstName;

    @FullTextField
    private String lastName;

    private String maidenName;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String birthDate;
    private String image;
    private String bloodGroup;
    private double height;
    private double weight;
    private String eyeColor;
    private String role;

    @FullTextField
    private String ssn;
    private String university;
    private String userAgent;
    private String ip;
    private String macAddress;
    private String ein;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    private Bank bank;

    @OneToOne(cascade = CascadeType.ALL)
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    private Crypto crypto;

    @OneToOne(cascade = CascadeType.ALL)
    private Hair hair;
}