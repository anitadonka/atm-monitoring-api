package com.example.atm_monitoring_api.repositories;


import com.example.atm_monitoring_api.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByTransactionType(String transactionType);

    @Query("SELECT t FROM Transaction t WHERE t.timestamp BETWEEN :startDate AND :endDate")
    List<Transaction> findTransactionsInDateRange(@Param("startDate") LocalDateTime startDate,
                                                  @Param("endDate") LocalDateTime endDate);

    // Additional custom query methods as needed
}


