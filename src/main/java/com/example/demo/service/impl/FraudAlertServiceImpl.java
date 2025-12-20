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

    @Override
    public FraudAlertRecord createAlert(FraudAlertRecord alert) {
        return repo.save(alert);
    }

    @Override
    public List<FraudAlertRecord> getAllAlerts() {
        return repo.findAll();
    }
}

