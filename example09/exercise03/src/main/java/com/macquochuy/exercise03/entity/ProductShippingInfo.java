package com.macquochuy.exercise03.entity;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_shipping_info")
public class ProductShippingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private UUID product_id;

    @Column(nullable = false, columnDefinition = "numeric")
    private double weight ;

    @Column(nullable = false)
    private String weight_unit;

    @Column(nullable = false, columnDefinition = "numeric")
    private double volume;

    @Column(nullable = false)
    private String volume_unit;

    @Column(nullable = false, columnDefinition = "numeric")
    private double dimension_width;

    @Column(nullable = false, columnDefinition = "numeric")
    private double dimension_height;

    @Column(nullable = false, columnDefinition = "numeric")
    private double dimension_depth;

    @Column(nullable = false)
    private String dimension_unit;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;
}
