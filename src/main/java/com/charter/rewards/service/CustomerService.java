package com.charter.rewards.service;

import com.charter.rewards.service.domain.Customer;
import com.charter.rewards.service.domain.CustomerList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired
    CustomerList customerList;

    public Customer getCustomerById (long customerId){

        for(Customer c : customerList.getCustomerList()){
            if( c.getCustomerID() == customerId){
                return c;
            }
        }

        return null;
    }

    public List<Customer> getAllCustomers (){
        return customerList.getCustomerList();
    }

}
