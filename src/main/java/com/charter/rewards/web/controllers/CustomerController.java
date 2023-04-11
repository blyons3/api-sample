package com.charter.rewards.web.controllers;

import com.charter.rewards.service.CustomerService;
import com.charter.rewards.service.domain.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/customer/")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("customerid/{customerid}")
    public Customer
    getCustomer(@PathVariable("customerid") long customerid){
        return customerService.getCustomerById(customerid);
    }

    @GetMapping("getallcustomers")
    public List<Customer>
    getAllCustomers(){
        return customerService.getAllCustomers();
    }

}
