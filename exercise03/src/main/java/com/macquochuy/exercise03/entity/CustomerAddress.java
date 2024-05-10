package com.macquochuy.exercise03.entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.uuid.UuidGenerator;

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
    @GeneratedValue(generator = "uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(nullable = false)    
    private UuidGenerator id;

    @Column(nullable = false)
    private UuidGenerator customer_id;

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
