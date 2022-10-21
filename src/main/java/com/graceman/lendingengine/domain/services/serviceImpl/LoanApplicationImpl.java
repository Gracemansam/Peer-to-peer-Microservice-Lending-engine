package com.graceman.lendingengine.domain.services.serviceImpl;

import com.graceman.lendingengine.domain.dto.LoanRequest;
import com.graceman.lendingengine.domain.exception.LoanApplicationNotFound;
import com.graceman.lendingengine.domain.exception.UserNotFoundException;
import com.graceman.lendingengine.domain.model.Loan;
import com.graceman.lendingengine.domain.model.LoanApplication;
import com.graceman.lendingengine.domain.model.User;
import com.graceman.lendingengine.domain.model.enums.UserRoles;
import com.graceman.lendingengine.domain.repository.LoanApplicationRepository;
import com.graceman.lendingengine.domain.repository.LoanRepository;
import com.graceman.lendingengine.domain.repository.UserRepository;
import com.graceman.lendingengine.domain.services.LoanApplicationService;
import com.graceman.lendingengine.domain.utils.ApiResponse;
import com.graceman.lendingengine.domain.utils.Responder;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanApplicationImpl implements LoanApplicationService {

    private final UserRepository userRepository;

    private final LoanApplicationRepository loanApplicationRepository;
    private final LoanRepository loanRepository;
    private final Responder responder;



    @Override
    public ResponseEntity<ApiResponse> createLoanApplication(LoanRequest loanRequest) {
        User user = userRepository.findUserByEmail(loanRequest.getEmail()).orElseThrow( () -> new UserNotFoundException ("User not found"));
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setAmount(loanRequest.getAmount());
        loanApplication.setInterestRate(loanRequest.getInterestRate());
        loanApplication.setRepaymentInDays(loanRequest.getRepaymentInDays());
        loanApplication.setUser(user);
        loanApplication.setApproved(false);
        loanApplicationRepository.save(loanApplication);
        return responder.success("Loan application created successfully", loanApplication);

    }
    @Override

    public List<LoanApplication> findAllLoanApplications() {
        return loanApplicationRepository.findAll();
    }
@Override
    public ResponseEntity<ApiResponse> approveLoanApplication(Long loanApplicationId, Long userId) {
        User lender = userRepository.findById(userId).orElseThrow( () -> new UserNotFoundException ("User not found"));
        if(lender.getRole() == UserRoles.LENDER ) {
            LoanApplication loanApplication = loanApplicationRepository.findById(loanApplicationId).orElseThrow( () -> new LoanApplicationNotFound ("Loan application not found"));
            loanApplication.setApproved(true);
            Loan loan =  Loan.builder().amount(loanApplication.getAmount()).interestRate(loanApplication.getInterestRate())
                    .amount(loanApplication.getAmount())
                    .interestRate(loanApplication.getInterestRate())
                    .repaymentInDays(loanApplication.getRepaymentInDays())
                    .user1(lender)
                    .user2(loanApplication.getUser())
                    .dateLent(LocalDateTime.now())
                    .dateDue(LocalDateTime.now().plusDays(loanApplication.getRepaymentInDays()))
                    .build();
            loanRepository.save(loan);
            return responder.success("Loan application approved successfully", loanApplication);
        }
        return responder.error("You are not authorized to approve loan application");
    }
    @Override
    public List <Loan> allApprovedLoanApplications() {
        return loanRepository.findAll();
    }


}
