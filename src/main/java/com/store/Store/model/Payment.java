package com.store.Store.model;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer order_id;
    private String payment_type;
    private Integer amount;

    // Default constructor
    public Payment() {
    }

    // Constructor with arguments
    public Payment(Integer order_id, String payment_type, Integer amount){
        this.order_id = order_id;
        this.payment_type = payment_type;
        this.amount = amount;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public Integer getAmount() {
        return amount;
    }
}
