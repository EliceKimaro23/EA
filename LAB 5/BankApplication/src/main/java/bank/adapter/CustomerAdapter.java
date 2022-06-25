package bank.adapter;

import bank.domain.Customer;
import bank.dto.CustomerDTO;

public class CustomerAdapter {

    public static CustomerDTO getcustomerDTOfromCustomer(Customer customer){
        return new CustomerDTO(customer.getName());
    }

    public static Customer getcustomerfromCustomerDTO(CustomerDTO customer){
        return new Customer(customer.getName());
    }

}
