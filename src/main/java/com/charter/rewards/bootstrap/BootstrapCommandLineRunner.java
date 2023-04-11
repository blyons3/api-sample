package com.charter.rewards.bootstrap;

import com.charter.rewards.service.domain.CustomerList;
import com.charter.rewards.service.domain.PurchaseTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CustomerList customerList;

    @Autowired
    private PurchaseTransactions purchaseTransactions;

    @Autowired
    public BootstrapCommandLineRunner(CustomerList customerList, PurchaseTransactions purchaseTransactions) {
        this.customerList = customerList;
        this.purchaseTransactions = purchaseTransactions;
    }
    @Override
    public void run(String... args) {

        LoadBootstrapData l = new LoadBootstrapData(customerList, purchaseTransactions);
        l.loadData();

    }

}