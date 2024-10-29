package com.example.atm_monitoring_api.services;



import com.example.atm_monitoring_api.models.Transaction;
import com.example.atm_monitoring_api.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerService {

    private final TransactionRepository transactionRepository;

    public CustomerService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public int countUniqueCustomersLast24Hours() {
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusHours(24);

        return (int) transactionRepository.findTransactionsInDateRange(startTime, endTime)
                .stream()
                .distinct()
                .count();
    }
}

