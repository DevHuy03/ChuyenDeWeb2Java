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
@Table(name = "shipping_rates")
public class ShippingRate {
    
    @Id
    @GeneratedValue(generator = "uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(nullable = false)    
    private UuidGenerator id;

    @Column(nullable = false)
    private int shipping_zone_id;

    @Column(nullable = false)
    private String weight_unit;

    @Column(nullable = false)
    private Double min_value;

    @Column(nullable = false)
    private Double max_value;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean no_max;

    @Column(nullable = false, columnDefinition = "numeric")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_zone_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ShippingZone shippingZone;

}