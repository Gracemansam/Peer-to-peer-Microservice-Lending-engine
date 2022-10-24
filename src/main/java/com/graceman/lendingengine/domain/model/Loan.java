package com.graceman.lendingengine.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter @AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user2;
    private int repaymentInDays;
    private double interestRate;
    private double totalRepayment;
    private LocalDateTime dateLent;
    private LocalDateTime dateDue;

}
