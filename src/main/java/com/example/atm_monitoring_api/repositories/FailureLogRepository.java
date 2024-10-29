package com.example.atm_monitoring_api.repositories;


import com.example.atm_monitoring_api.models.FailureLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository

public interface FailureLogRepository extends JpaRepository<FailureLog, Long> {

    List<FailureLog> findByTransactionType(String transactionType);

    @Query("SELECT f FROM FailureLog f WHERE f.timestamp BETWEEN :startDate AND :endDate")
    List<FailureLog> findFailuresInDateRange(@Param("startDate") LocalDateTime startDate,
                                             @Param("endDate") LocalDateTime endDate);

    // Additional custom query methods as needed
}
