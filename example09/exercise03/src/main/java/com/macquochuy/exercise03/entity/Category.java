package com.macquochuy.exercise03.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = true)
    private UUID parent_id;

    @Column(nullable = true)
    private String category_name;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String category_description;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String icon;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String image;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String placeholder;

    @Column(nullable = true)
    private boolean active;

    @Column(nullable = true)
    private LocalDateTime created_at = LocalDateTime.now();

    @Column(nullable = true)
    private LocalDateTime updated_at;

    @Column(nullable = true)
    private UUID created_by;

    @Column(nullable = true)
    private UUID updated_by;

    // Navigation properties
    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Category> subCategories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id", insertable = false, updatable = false)
    private StaffAccount staffAccount;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", referencedColumnName = "id", insertable = false, updatable = false)
    private StaffAccount staffaccount;
}
