package com.macquochuy.exercise02.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    @Column(nullable = true)
    private Long sub_category_id;

    @Column(nullable = false)
    private String category_title;

    @Column(nullable = false, unique = true)
    private String image_url;

    @Column(nullable = false)
    private String created_at;

    @Column(nullable = false)
    private String updated_at;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sub_category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
    private Category parentCategory; // Thay vì 'sub_categories'

    @OneToMany(mappedBy = "parentCategory")
    private List<Category> subcategories;

}
