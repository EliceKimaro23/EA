package com.example.customer.service;

import com.example.customer.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
     Customer addCustomer(Customer customer);
     Customer getCustomerById(Integer id);



}
