package com.example.demo.service.impl;

import com.example.demo.service.FraudAlertService;
import com.example.demo.entity.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    @Autowired
    private FraudAlertRecordRepository repo;

    public FraudAlertRecord createAlert(FraudAlertRecord alert) {
        return repo.save(alert);
    }

    public void resolveAlert(Long id) {
        FraudAlertRecord a = repo.findById(id).orElse(null);
        if (a != null) {
            a.setResolved(true);
            repo.save(a);
        }
    }

    public List<FraudAlertRecord> getAlertsBySerial(String serialNumber) {
        return repo.findAll(); // simple
    }

    public List<FraudAlertRecord> getAlertsByClaim(Long claimId) {
        return repo.findByClaimId(claimId);
    }

    public FraudAlertRecord getAlertById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<FraudAlertRecord> getAllAlerts() {
        return repo.findAll();
    }
}
