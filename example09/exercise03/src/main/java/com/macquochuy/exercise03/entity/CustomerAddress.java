package com.macquochuy.exercise03.entity;

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
@Table(name = "customer_addresses")
public class CustomerAddress {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private UUID customer_id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String address_line1;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String address_line2;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false)
    private String dial_code;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String postal_code;   

    @Column(nullable = false)
    private String city; 

    // Navigation properties
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Customer customer;
}
