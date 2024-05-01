package com.store.Store.controller;

import com.store.Store.model.Order;
import com.store.Store.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/all-orders")
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable("id") Integer id){
        return orderRepository.findById(id).get();
    }

    @PostMapping("/order")
    public Order postOrder(@RequestBody Map<String, String> body){
        String customer = body.get("customer");
        Integer billed_amount = Integer.parseInt(body.get("billed_amount"));
        Integer paid_amount = Integer.parseInt(body.get("paid_amount"));
        Boolean is_payment_done = Boolean.parseBoolean(body.get("is_payment_done"));

        Order newOrder = new Order(customer, is_payment_done, billed_amount, paid_amount);
        return orderRepository.save(newOrder);
    }

    @PutMapping("/order/{id}")
    public Order updateOrder(@PathVariable("id") Integer id,
                               @RequestBody Map<String, String> body){
        Order current = orderRepository.findById(id).get();
        current.setCustomer(body.get("customer"));
        current.setBilled_amount(Integer.parseInt(body.get("billed_amount")));
        current.setPaid_amount(Integer.parseInt(body.get("paid_amount")));
        current.setIs_payment_done(Boolean.parseBoolean(body.get("is_payment_done")));

        orderRepository.save(current);
        return current;
    }

    @DeleteMapping("/order/{id}")
    public boolean deleteOrder(@PathVariable("id") Integer id){
        if(!orderRepository.findById(id).equals(Optional.empty())) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}