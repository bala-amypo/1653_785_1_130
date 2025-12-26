package com.example.demo.service.impl;

import java.util.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;

public class FraudAlertServiceImpl {

    private final FraudAlertRecordRepository repo;

    public FraudAlertServiceImpl(FraudAlertRecordRepository repo) {
        this.repo = repo;
    }

    public FraudAlertRecord createAlert(FraudAlertRecord r) {
        return repo.save(r);
    }

    public List<FraudAlertRecord> getAllAlerts() {
        return repo.findAll();
    }

    public FraudAlertRecord resolveAlert(Long id) {
        FraudAlertRecord f = repo.findById(id)
                .orElseThrow(NoSuchElementException::new);
        f.setResolved(true);
        return repo.save(f);
    }
}
