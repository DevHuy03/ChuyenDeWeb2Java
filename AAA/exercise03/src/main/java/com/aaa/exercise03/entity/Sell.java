package com.aaa.exercise03.entity;

import java.util.UUID;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sells")
public class Sell {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private UUID product_id;

    @Column(nullable = true, columnDefinition = "NUMERIC")
    private double price;

    @Column(nullable = true)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;
}
