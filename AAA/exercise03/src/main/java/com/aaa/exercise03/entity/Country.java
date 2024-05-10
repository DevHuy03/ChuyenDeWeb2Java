package com.aaa.exercise03.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String iso;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String upper_name;

    @Column(nullable = false)
    private String iso3;

    @Column(nullable = true)
    private int num_code;

    @Column(nullable = false)
    private int phone_code;

}