
package com.macquochuy.exercise02.Entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LikeId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @Column(name = "like_date")
    private Date like_date;

    public LikeId(Long userId, Long productId, String likeDate) {
        this.user = new User(userId);
        this.product = new Product(productId);

    }

    // Get User
    public User getUser() {
        return this.user;
    }

    // Set User
    public void setUser(User user) {
        this.user = user;
    }

    // Get Product
    public Product getProduct() {
        return this.product;
    }

    // Set Product
    public void setProduct(Product product) {
        this.product = product;
    }

    // Get like date
    public Date getLike_date() {
        return this.like_date;
    }

    // Set like date
    public void setLike_date(Date like_date) {
        this.like_date = like_date;
    }
}
