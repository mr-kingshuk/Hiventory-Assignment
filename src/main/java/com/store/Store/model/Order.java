package com.store.Store.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String customer;
    private Boolean is_payment_done;
    private Integer billed_amount;
    private Integer paid_amount;

    public Order(String customer, Boolean is_payment_done, Integer billed_amount, Integer paid_amount) {
        this.customer = customer;
        this.is_payment_done = is_payment_done;
        this.billed_amount = billed_amount;
        this.paid_amount = paid_amount;
    }

    public Integer getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Boolean getIs_payment_done() {
        return is_payment_done;
    }

    public void setIs_payment_done(Boolean is_payment_done) {
        this.is_payment_done = is_payment_done;
    }

    public Integer getBilled_amount() {
        return billed_amount;
    }

    public void setBilled_amount(Integer billed_amount) {
        this.billed_amount = billed_amount;
    }

    public Integer getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(Integer paid_amount) {
        this.paid_amount = paid_amount;
    }
}
