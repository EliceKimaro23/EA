package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

  @PostMapping
    public Customer addNewCustomer(@RequestBody  Customer customer){
      return  customerService.addCustomer(customer);
  }
@GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Integer id){
      return  customerService.getCustomerById(id);
}

}
