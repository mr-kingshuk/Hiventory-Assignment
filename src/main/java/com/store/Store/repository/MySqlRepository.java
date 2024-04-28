package com.store.Store.repository;

import com.store.Store.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySqlRepository extends JpaRepository<Order, Integer> {
}
