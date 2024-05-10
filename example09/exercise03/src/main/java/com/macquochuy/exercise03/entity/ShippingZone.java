package com.macquochuy.exercise03.entity;

import java.util.Date;
import java.util.UUID;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shipping_zones")
public class ShippingZone {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String display_name;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean active;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean free_shipping;

    @Column(nullable = false)
    private String rate_type;

    @Column(nullable = false)
    private Date created_at;

    @Column(nullable = false)
    private Date updated_at;

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