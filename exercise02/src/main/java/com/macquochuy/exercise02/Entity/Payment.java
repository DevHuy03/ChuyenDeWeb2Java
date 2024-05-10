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
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payment_id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(nullable = false)
    private boolean payed; // Đổi tên thành payed

    @Column(nullable = false)
    private String payment_status;

    @Column(nullable = false)
    private Date created_at;

    @Column(nullable = false)
    private Date updated_at;

    @JsonIgnore
    @OneToMany(mappedBy = "payment")
    private List<OrderItem> orderItems;

    // Phương thức setter cho payment_id
    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }
}
