package com.macquochuy.exercise02.Entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    // Constructor with productId parameter
    public Product(Long product_id) {
        this.product_id = product_id;
    }

    @Column(nullable = false)
    private String product_title;

    @Column(nullable = false, unique = true)
    private String image_url;

    @Column(nullable = false)
    private String sku;

    @Column(nullable = false)
    private double price_unit;

    @Column(nullable = false)
    private double quantity;

    @Column(nullable = false)
    private String created_at;

    @Column(nullable = false)
    private String updated_at;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Like> likes;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;
}
