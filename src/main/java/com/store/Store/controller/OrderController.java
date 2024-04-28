package com.store.Store.controller;

import com.store.Store.model.Order;
import com.store.Store.repository.MySqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    MySqlRepository mySqlRepository;

    @GetMapping("/all-orders")
    public List<Order> getAllOrders(){
        return mySqlRepository.findAll();
    }
}
