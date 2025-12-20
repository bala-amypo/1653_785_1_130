package com.example.demo.service;

import com.example.demo.entity.FraudAlertRecord;
import java.util.List;

public interface FraudAlertService {

    FraudAlertRecord createAlert(FraudAlertRecord alert);

    void resolveAlert(Long id);

    List<FraudAlertRecord> getAlertsBySerial(String serialNumber);

    List<FraudAlertRecord> getAlertsByClaim(Long claimId);

    FraudAlertRecord getAlertById(Long id);

    List<FraudAlertRecord> getAllAlerts();
}
