package com.macquochuy.exercise03.entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.uuid.UuidGenerator;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "variant_options")
public class VariantOption {

    @Id
    @GeneratedValue(generator = "uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(nullable = false)    
    private UuidGenerator id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String title;

    @Column(nullable = false)
    private UuidGenerator image_id;

    @Column(nullable = false)
    private UuidGenerator product_id;

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
