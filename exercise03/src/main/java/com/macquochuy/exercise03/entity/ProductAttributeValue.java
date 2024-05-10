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
@Table(name = "product_attribute_values")
public class ProductAttributeValue {

    @Id
    @GeneratedValue(generator = "uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(nullable = false)    
    private UuidGenerator id;
    
    @Column(nullable = false)
    private UuidGenerator product_attribute_id;

    @Column(nullable = false)
    private UuidGenerator attribute_value_id;

    @ManyToOne
    @JoinColumn(name = "product_attribute_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ProductAttribute productattribute;

    @ManyToOne
    @JoinColumn(name = "attribute_value_id", referencedColumnName = "id", insertable = false, updatable = false)
    private AttributeValue attributeValue;
}
