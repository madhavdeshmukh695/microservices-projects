package com.eazybytes.loans.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter@Setter@ToString@AllArgsConstructor
public class Loans {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    private String MobileNumber;

    private String LoanNumber;

    private String loanType;

    private Integer totalLoan;

    private int amountPaid;

    private int outstandingAmount;
}
