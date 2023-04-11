package com.charter.rewards.web.controllers;

import com.charter.rewards.service.PointsCalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/points/")
@RestController
public class PointsController {

    private final PointsCalculatorService pointsCalculatorService;

    public PointsController(PointsCalculatorService pointsCalculatorService) {
        this.pointsCalculatorService = pointsCalculatorService;
    }


    @GetMapping("pointsbycustmonthandyear/customerid/{customerid}/month/{month}/year/{year}")
    public long
    getRewardByMonthAndYear(@PathVariable("customerid") long customerId,
                            @PathVariable("month") int month, @PathVariable("year") int year){
        return pointsCalculatorService.getPointsByCustMonthAndYear(customerId, month, year);
    }

}
