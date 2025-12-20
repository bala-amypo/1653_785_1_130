package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.FraudAlertRecord;

public interface FraudAlertRecordRepository
        extends JpaRepository<FraudAlertRecord, Long> {
}
