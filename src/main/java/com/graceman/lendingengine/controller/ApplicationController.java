package com.graceman.lendingengine.controller;

import com.graceman.lendingengine.domain.dto.LoanRequest;
import com.graceman.lendingengine.domain.model.Loan;
import com.graceman.lendingengine.domain.model.LoanApplication;
import com.graceman.lendingengine.domain.model.User;
import com.graceman.lendingengine.domain.repository.LoanApplicationRepository;
import com.graceman.lendingengine.domain.services.LoanApplicationService;
import com.graceman.lendingengine.domain.services.UserService;
import com.graceman.lendingengine.domain.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ApplicationController {

    private final UserService userService;
    private final LoanApplicationService loanApplicationService;


    @PostMapping("/loanApplication")
    public ResponseEntity<ApiResponse> createLoanApplication( @RequestBody LoanRequest loanRequest) {
        return loanApplicationService.createLoanApplication(loanRequest);
    }

    @GetMapping("/get-all-loan-applications")
    public List<LoanApplication> getAllLoanApplications() {
        return loanApplicationService.findAllLoanApplications();
    }

    @GetMapping("/get-all-users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/approve-loan/{loanApplicationId}/{userId}")
    public ResponseEntity<ApiResponse> approveLoanApplication(@PathVariable Long loanApplicationId, @PathVariable Long userId) {
        return loanApplicationService.approveLoanApplication(loanApplicationId, userId);
    }
    @GetMapping("/get-all-approved-loans")
    public List<Loan> getAllApprovedLoan() {
        return loanApplicationService.allApprovedLoanApplications();
    }
}

