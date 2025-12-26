package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;

public interface FraudAlertRecordRepository {
    Optional<FraudAlertRecord> findById(Long id);
    List<FraudAlertRecord> findAll();
    FraudAlertRecord save(FraudAlertRecord f);
}
