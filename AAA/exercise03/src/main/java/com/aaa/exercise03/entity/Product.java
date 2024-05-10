package com.aaa.exercise03.entity;

import java.util.UUID;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String slug;

    @Column(nullable = true)
    private String product_name;

    @Column(nullable = true)
    private String sku;

    @Column(nullable = true, columnDefinition = "numeric")
    private double sale_price;
    
    @Column(nullable = true, columnDefinition = "numeric")
    private double compare_price;

    @Column(nullable = true, columnDefinition = "numeric")
    private double buying_price;

    @Column(nullable = true)
    private int quantity;

    @Column(nullable = true)
    private String short_description;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String product_description;

    @Column(nullable = true)
    private String product_type;

    @Column(nullable = true, columnDefinition = "boolean default true")
    private boolean published;

    @Column(nullable = true, columnDefinition = "boolean default true")
    private boolean disable_out_of_stock;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String note;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String sale_percent;

    @Column(nullable = true)
    private LocalDateTime created_at = LocalDateTime.now();

    @Column(nullable = true)
    private LocalDateTime updated_at;

    @Column(nullable = true)
    private UUID created_by;

    @Column(nullable = true)
    private UUID updated_by;

    // Navigation properties
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id", insertable = false, updatable = false)
    private StaffAccount staffAccount;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", referencedColumnName = "id", insertable = false, updatable = false)
    private StaffAccount staffaccount;
}
