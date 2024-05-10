package com.macquochuy.exercise03.entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.uuid.UuidGenerator;

import java.util.Date;
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
    @GeneratedValue(generator = "uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(nullable = false)    
    private UuidGenerator id;

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
    private UuidGenerator created_by;

    @Column(nullable = true)
    private UuidGenerator updated_by;

    // Navigation properties
}
