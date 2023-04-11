package com.charter.rewards.service.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseOrderHeaderTest {
    @Test
    void testGetPoints(){

        // Test boundary condition negative numbers get no points.
        PurchaseOrderHeader rt0 = new PurchaseOrderHeader(1, 2,  -5,
                LocalDate.of(2023, 4, 11));
        assertEquals(rt0.getPoints(), 0);

        // So do transactions with no dollars.
        PurchaseOrderHeader rt1 = new PurchaseOrderHeader(1, 2, 0,
                LocalDate.of(2023, 4, 11));
        assertEquals(rt1.getPoints(), 0);

        // Transactions for $51 get 1 point.
        PurchaseOrderHeader rt2 = new PurchaseOrderHeader(1, 2, 51,
                LocalDate.of(2023, 4, 11));
        assertEquals(rt2.getPoints(), 1);

        // Transactions for $120 dollars get 90 points.
        PurchaseOrderHeader rt3 = new PurchaseOrderHeader(1, 2, 120,
                LocalDate.of(2023, 4, 11));
        assertEquals(rt3.getPoints(), 90);

    }
}
