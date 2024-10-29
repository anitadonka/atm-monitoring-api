package com.example.atm_monitoring_api.repositories;



import com.example.atm_monitoring_api.models.CameraMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository

public interface CameraMediaRepository extends JpaRepository<CameraMedia, Long> {

    @Query("SELECT c FROM CameraMedia c WHERE c.startTime >= :startDate AND c.endTime <= :endDate")
    List<CameraMedia> findMediaInDateRange(@Param("startDate") LocalDateTime startDate,
                                           @Param("endDate") LocalDateTime endDate);

    // Additional custom query methods as needed
}
