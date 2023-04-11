package com.charter.rewards.bootstrap;

import com.charter.rewards.service.domain.Customer;
import com.charter.rewards.service.domain.CustomerList;
import com.charter.rewards.service.domain.PurchaseOrderHeader;
import com.charter.rewards.service.domain.PurchaseTransactions;

import java.time.LocalDate;

public class LoadBootstrapData {

    CustomerList customerList;
    PurchaseTransactions purchaseTransactions;


    public LoadBootstrapData(CustomerList customerList, PurchaseTransactions purchaseTransactions) {
        this.customerList = customerList;
        this.purchaseTransactions = purchaseTransactions;
    }
    public void loadData(){

        // Load up some customers:
        Customer c1 = Customer.builder()
                .customerID(1)
                .customerName("Bill Lyons")
                .build();
        customerList.getCustomerList().add(c1);

        Customer c2 = Customer.builder()
                .customerID(2)
                .customerName("Holly Lyons")
                .build();
        customerList.getCustomerList().add(c2);

        Customer c3 = Customer.builder()
                .customerID(3)
                .customerName("Charlie Charter")
                .build();
        customerList.getCustomerList().add(c3);

        // Load up some rewards transactions:
        PurchaseOrderHeader r1 = PurchaseOrderHeader.builder()
                .customerId(1)
                .transactionID(1)
                .amount(120)
                .transactionDate(LocalDate.of(2023, 3, 30))
                .build();
        purchaseTransactions.getTransactions().add(r1);

        PurchaseOrderHeader r2 = PurchaseOrderHeader.builder()
                .customerId(1)
                .transactionID(2)
                .amount(120)
                .transactionDate(LocalDate.of(2023, 3, 31))
                .build();
        purchaseTransactions.getTransactions().add(r2);
        PurchaseOrderHeader r3 = PurchaseOrderHeader.builder()
                .customerId(1)
                .transactionID(3)
                .amount(51)
                .transactionDate(LocalDate.of(2023, 4, 11))
                .build();
        purchaseTransactions.getTransactions().add(r3);
        PurchaseOrderHeader r4 = PurchaseOrderHeader.builder()
                .customerId(2)
                .transactionID(4)
                .amount(101)
                .transactionDate(LocalDate.of(2023, 4, 11))
                .build();
        purchaseTransactions.getTransactions().add(r4);

    }

}
