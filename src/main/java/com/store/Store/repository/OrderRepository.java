package com.store.Store.repository;

import com.store.Store.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE o.customer = ?1 AND o.is_payment_done = false ORDER BY o.id ASC")
    List<Order> findByCustomerNameAndIsPaymentDoneOrderByOrderIdAsc(String customer);
}
