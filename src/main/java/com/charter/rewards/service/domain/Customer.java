package com.charter.rewards.service.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class Customer {

    private long customerID;
    private String customerName;

    @Builder
    public Customer(long customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
    }
}
