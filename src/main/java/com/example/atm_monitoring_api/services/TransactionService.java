package com.example.atm_monitoring_api.services;

import com.example.atm_monitoring_api.dtos.TransactionBreakdownResponse;
import com.example.atm_monitoring_api.models.Transaction;
import com.example.atm_monitoring_api.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionBreakdownResponse getTransactionBreakdown(LocalDateTime startDate, LocalDateTime endDate) {
        List<Transaction> transactions = transactionRepository.findTransactionsInDateRange(startDate, endDate);

        //int depositCount = (int) transactions.stream().filter(t -> t.getTransactionType().equals("DEPOSIT")).count();
        //int withdrawalCount = (int) transactions.stream().filter(t -> t.getTransactionType().equals("WITHDRAWAL")).count();
        //int balanceInquiryCount = (int) transactions.stream().filter(t -> t.getTransactionType().equals("BALANCE_INQUIRY")).count();

        return new TransactionBreakdownResponse(0, 0, 0);
    }
}
