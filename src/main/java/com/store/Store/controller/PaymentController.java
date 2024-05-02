package com.store.Store.controller;

import com.store.Store.model.Customer;
import com.store.Store.model.Order;
import com.store.Store.model.Payment;
import com.store.Store.repository.CustomerRepository;
import com.store.Store.repository.OrderRepository;
import com.store.Store.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PaymentController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @PostMapping("/addpayment")
    public String addPayment(@RequestBody Map<String, String> body){
        Integer amount = Integer.parseInt(body.get("amount"));
        Integer customerId = Integer.parseInt(body.get("customerId"));

        //gets and updates
        Customer customer = customerRepository.findById(customerId).get();
        if (customer == null) {
            return "Customer not found";
        }

        //set newBalance to the customer table
        Integer newBalance = customer.getBalance() + amount;
        customer.setBalance(newBalance);
        customerRepository.save(customer);

        // Fetch orders based on customer name and is_payment_done
        List<Order> orders = orderRepository.findByCustomerNameAndIsPaymentDoneOrderByOrderIdAsc(customer.getName());

        // Process the retrieved orders
        for(Order order : orders) {
            // Process each order as needed
            Integer billed_amount = order.getBilled_amount();
            Integer paid_amount = order.getPaid_amount();
            Integer due_amount = billed_amount - paid_amount;

            if (due_amount > amount) {
                order.setPaid_amount(paid_amount + amount);
                Payment pay = new Payment(order.getId(), "SQUARED", amount);
                amount = 0;
                paymentRepository.save(pay);
                orderRepository.save(order);
                break;
            }
            order.setPaid_amount(billed_amount);
            amount = amount - due_amount;
            order.setIs_payment_done(true);

            Payment pay = new Payment(order.getId(), "SQUARED", due_amount);
            paymentRepository.save(pay);
            orderRepository.save(order);
        }
        if(amount != 0){
            Payment pay = new Payment(0, "ADVACNCE", amount);
            amount = 0;
            paymentRepository.save(pay);
        }
        return "Payment done succesfully";
    }
}
