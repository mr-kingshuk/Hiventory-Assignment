package com.store.Store.controller;

import com.store.Store.model.Order;
import com.store.Store.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/all-orders")
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/get-order/{id}")
    public Order getOrder(@PathVariable("id") Integer id){
        return orderRepository.findById(id).get();
    }
}
