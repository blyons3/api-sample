package com.charter.rewards.service;

import com.charter.rewards.service.domain.PurchaseOrderHeader;
import lombok.RequiredArgsConstructor;
import com.charter.rewards.service.domain.PurchaseTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointsCalculatorService {

    public static final int SINGLE_POINTS = 1;
    public static final int DOUBLE_POINTS = 2;
    public static final double ONE_POINT_THRESHOLD = 50.0;
    public static final double TWO_POINT_THRESHOLD = 100.0;

    @Autowired
    PurchaseTransactions purchaseTransactions;

    public static long getPoints(PurchaseOrderHeader rt){

        double transactionAmount = rt.getAmount();

        // Transactions < the ONE_POINT_THRESHOLD earn no points.
        if (transactionAmount <= ONE_POINT_THRESHOLD){
            return 0;
        }

        // Transactions > the SINGLE_POINTS_THRESHOLD and < the DOUBLE_POINTS_THRESHOLD get SINGLE_POINTS
        else if ((transactionAmount >= ONE_POINT_THRESHOLD) && (transactionAmount < TWO_POINT_THRESHOLD)){
            return   Math.round(((transactionAmount) - ONE_POINT_THRESHOLD ) * SINGLE_POINTS);
        }

        // Transactions > than the DOUBLE_POINTS_THRESHOLD get DOUBLE and SINGLE POINTS
        else // (transactionAmount >= TWO_POINT_THRESHOLD) {
            return Math.round(((transactionAmount - TWO_POINT_THRESHOLD) * DOUBLE_POINTS) +
                    (ONE_POINT_THRESHOLD * SINGLE_POINTS));
        }

//        public long getRewardsByCustomerAndMonth(long customerId, int month, int year, Transactions transactions){
        public Long getPointsByCustMonthAndYear(long customerId, int month, int year){

            return purchaseTransactions.getTransactions().stream()
                            .filter(p -> p.getCustomerId() == customerId)
                            .filter(p -> p.getTransactionDate().getMonthValue() == month )
                            .filter(p -> p.getTransactionDate().getYear() == year)
                            .mapToLong(PurchaseOrderHeader::getPoints).sum();
        }
    }
