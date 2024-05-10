package com.macquochuy.exercise03.entity;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_attribute_values")
public class ProductAttributeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(nullable = false)
    private UUID product_attribute_id;

    @Column(nullable = false)
    private UUID attribute_value_id;

    @ManyToOne
    @JoinColumn(name = "product_attribute_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ProductAttribute productattribute;

    @ManyToOne
    @JoinColumn(name = "attribute_value_id", referencedColumnName = "id", insertable = false, updatable = false)
    private AttributeValue attributeValue;
}
