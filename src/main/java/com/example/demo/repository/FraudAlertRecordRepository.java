package com.example.demo.repository;
import com.example.demo.model.FraudAlertRecord;
import org.springframework.stereotype.Repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface FraudAlertRecordRepository extends JpaRepository<FraudAlertRecord, Long>{
    Optional<FraudAlertRecord> findById(Long id);
    List<FraudAlertRecord> findByClaimId(Long claimId);
    FraudAlertRecord save(FraudAlertRecord alert);
}
