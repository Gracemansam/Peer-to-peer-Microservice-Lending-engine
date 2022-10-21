package com.graceman.lendingengine.domain.services;

import com.graceman.lendingengine.domain.dto.LoanRequest;
import com.graceman.lendingengine.domain.model.Loan;
import com.graceman.lendingengine.domain.model.LoanApplication;
import com.graceman.lendingengine.domain.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LoanApplicationService {


    ResponseEntity<ApiResponse> createLoanApplication(LoanRequest loanRequest);

    List<LoanApplication> findAllLoanApplications();

    ResponseEntity<ApiResponse> approveLoanApplication(Long loanApplicationId, Long userId);

    List <Loan> allApprovedLoanApplications();
}
