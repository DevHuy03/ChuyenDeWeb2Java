package com.macquochuy.exercise03.entity;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.uuid.UuidGenerator;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "suppliers")
public class Supplier {
    
    @Id
    @GeneratedValue(generator = "uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(nullable = false)    
    private UuidGenerator id;

    @Column(nullable = false)
    private String supplier_name;

    @Column(nullable = true)
    private String company;

    @Column(nullable = true)
    private String phone_number;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String address_line1;

    @Column(nullable = true)
    private String address_line2;

    @Column(nullable = false)
    private int country_id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String note;

    @Column(updatable = false)
    private Date created_at;

    @Column(nullable = false)
    private Date updated_at;

    @Column(nullable = false)
    private UuidGenerator created_by;

    @Column(nullable = false)
    private UuidGenerator updated_by;

    // Navigation properties
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id", insertable = false, updatable = false)
    private StaffAccount staffAccount;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", referencedColumnName = "id", insertable = false, updatable = false)
    private StaffAccount staffaccount;
}