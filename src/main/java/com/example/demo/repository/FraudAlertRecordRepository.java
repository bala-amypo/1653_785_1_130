package com.example.demo.repository;

import com.example.demo.model.FraudAlertRecord;
import java.util.*;

public interface FraudAlertRecordRepository {
    Optional<FraudAlertRecord> findById(Long id);
    List<FraudAlertRecord> findByClaimId(Long claimId);
    FraudAlertRecord save(FraudAlertRecord alert);
}
