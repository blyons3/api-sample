package com.charter.rewards.service.domain;

import com.charter.rewards.service.PointsCalculatorService;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Data
@Component
public class PurchaseOrderHeader {

    private long transactionID;

    private long customerId;

    private double amount;

    private LocalDate transactionDate;

    private long points;
    @Builder
    public PurchaseOrderHeader(long transactionID,
                               long customerId,
                               double amount,
                               LocalDate transactionDate) {

        this.transactionID = transactionID;
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.points = PointsCalculatorService.getPoints(this);
    }
}
