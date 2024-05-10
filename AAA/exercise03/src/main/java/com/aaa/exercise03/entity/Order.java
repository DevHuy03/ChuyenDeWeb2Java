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
@Table(name = "orders")
public class Order {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private UUID coupon_id;

    @Column(nullable = false)
    private UUID customer_id;

    @Column(nullable = false)
    private UUID order_status_id;

    @Column(nullable = true)
    private Date order_approved_at;

    @Column(nullable = true)
    private Date order_delivered_carrier_date;

    @Column(nullable = true)
    private Date order_delivered_customer_date;

    @Column(nullable = true)
    private Date created_at;

    @Column(nullable = true)
    private UUID updated_by;

    // Navigation properties
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", referencedColumnName = "id", insertable = false, updatable = false)
    private StaffAccount staffaccount;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "order_status_id", referencedColumnName = "id", insertable = false, updatable = false)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "coupon_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Coupon coupon;
}
