package com.graceman.lendingengine.domain.dto;

import com.graceman.lendingengine.domain.model.User;
import lombok.Data;

@Data
public class LoanRequest {
    private double amount;
    private int repaymentInDays;
    private double interestRate;
    private String email;


}
