package com.aaa.exercise03.entity;

import java.util.Date;
import java.util.UUID;

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
@Table(name = "coupons")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false, columnDefinition = "numeric")
    private Double discount_value;

    @Column(nullable = false)
    private String discount_type;

    @Column(nullable = false, columnDefinition = "numeric")
    private Double times_used;

    @Column(nullable = false, columnDefinition = "numeric")
    private Double max_usage;

    @Column(nullable = false, columnDefinition = "numeric")
    private Double order_amount_limit;

    @Column(nullable = false)
    private Date coupon_start_date;   

    @Column(nullable = false)
    private Date coupon_end_date;

    @Column(nullable = true)
    private Date created_at;

    @Column(nullable = true)
    private Date updated_at;

    @Column(nullable = true)
    private UUID created_by;

    @Column(nullable = true)
    private UUID updated_by;

    // Navigation properties
}
