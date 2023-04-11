package com.charter.rewards.service;

import com.charter.rewards.service.domain.PurchaseTransactions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PointsCalculatorServiceTest {

    @Autowired
     PurchaseTransactions purchaseTransactions;

    @Autowired
    PointsCalculatorService pointsCalculatorService;

     @Test
    void testRewardsByCustomerAndMonthCalculations(){

        assertEquals(pointsCalculatorService.getPointsByCustMonthAndYear(1, 3, 2023), 180);
        assertEquals(pointsCalculatorService.getPointsByCustMonthAndYear(1,4, 2023), 1);
        assertEquals(pointsCalculatorService.getPointsByCustMonthAndYear(2,4, 2023), 52);

    }

}
