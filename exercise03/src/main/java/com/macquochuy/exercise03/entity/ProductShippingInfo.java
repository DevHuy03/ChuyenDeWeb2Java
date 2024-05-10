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
@Table(name = "product_shipping_info")
public class ProductShippingInfo {

    @Id
    @GeneratedValue(generator = "uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(nullable = false)    
    private UuidGenerator id;

    @Column(nullable = false)
    private UuidGenerator product_id;

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
