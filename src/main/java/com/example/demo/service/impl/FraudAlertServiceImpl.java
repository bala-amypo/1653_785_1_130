package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import java.util.*;

public class FraudAlertServiceImpl {

    private final FraudAlertRecordRepository repo;

    public FraudAlertServiceImpl(FraudAlertRecordRepository repo) {
        this.repo = repo;
    }

    public FraudAlertRecord createAlert(FraudAlertRecord alert) {
        return repo.save(alert);
    }

    public FraudAlertRecord resolveAlert(Long id) {
        FraudAlertRecord alert = repo.findById(id).orElseThrow();
        alert.setResolved(true);
        return repo.save(alert);
    }

    public List<FraudAlertRecord> getAlertsByClaim(Long claimId) {
        return repo.findByClaimId(claimId);
    }
}
