package com.aaa.exercise03.entity;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "variant_options")
public class VariantOption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String title;

    @Column(nullable = false)
    private UUID image_id;

    @Column(nullable = false)
    private UUID product_id;

    @Column(nullable = true, columnDefinition = "numeric")
    private double sale_price;

    @Column(nullable = true, columnDefinition = "numeric")
    private double compare_price;

    @Column(nullable = true, columnDefinition = "numeric")
    private double buying_price;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String sku;

    @Column(nullable = true, columnDefinition = "boolean default true")
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Gallery gallery;
}
