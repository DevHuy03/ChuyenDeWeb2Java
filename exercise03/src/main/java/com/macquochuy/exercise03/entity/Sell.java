package com.macquochuy.exercise03.entity;

import java.util.UUID;

import org.hibernate.id.uuid.UuidGenerator;

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
    private UuidGenerator product_id;

    @Column(nullable = true, columnDefinition = "NUMERIC")
    private double price;

    @Column(nullable = true)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;
}
